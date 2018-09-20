package cn.pangpython;

import cn.pangpython.sohu.dao.NewsInfoDao;
import cn.pangpython.sohu.model.po.NewsInfo;
import cn.pangpython.sohu.model.query.NewsInfoQuery;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            NewsInfoDao newsInfoDao = sqlSession.getMapper(NewsInfoDao.class);
            NewsInfoQuery newsInfoQuery = new NewsInfoQuery();
            List<NewsInfo> query = newsInfoDao.query(newsInfoQuery);
            query.forEach((newsInfo)->{
                System.out.println(newsInfo);
                createHtmlFromModel(newsInfo);
            });
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 使用模板生成HTML代码
     */
    public static void createHtmlFromModel(NewsInfo newsInfo) {
        FileWriter out = null;
        try {
            // 通过FreeMarker的Confuguration读取相应的模板文件
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            // 设置模板路径
            configuration.setClassForTemplateLoading(App.class, "/temp/");
            // 设置默认字体
            configuration.setDefaultEncoding("utf-8");

            // 获取模板
            Template template = configuration.getTemplate("template.ftl");
            //设置模型
            //设置输出文件
            File file = new File(newsInfo.getId()+".html");
            if(!file.exists()) {
                file.createNewFile();
            }
            //设置输出流
            out = new FileWriter(file);
            Map<String,Object> map = new HashMap<>();
//            map.put("keywords","seo,推广,打广告,流量,新闻,山竹,可爱的广东人,美女,壁纸");
//            map.put("desc","推广请联系pangpython#qq.com,日活百万流量，引爆你的广告！");
            map.put("title", newsInfo.getTitle());
            map.put("editor", newsInfo.getEditor());
            map.put("date", newsInfo.getDate());
            map.put("cate", newsInfo.getCate());
            map.put("srcFrom", newsInfo.getSrcfrom());
            map.put("url", newsInfo.getUrl());
            map.put("content", newsInfo.getContent());
//            template.process(map, out);
            template.process(newsInfo, out);
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if(null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
