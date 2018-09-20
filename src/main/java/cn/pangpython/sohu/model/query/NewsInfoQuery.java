package cn.pangpython.sohu.model.query;

/**
 * Description: NewsInfoQuery
 * Author: curd generator
 * Create: 2016-02-18 11:06
 */
public class NewsInfoQuery {
	private Integer id;
	private String title;
	private String url;
	private String cate;
	private String date;
	private String srcfrom;
	private String content;
	private String editor;
	private Long offset;
	private Integer limit;

	public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

	public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

	public String getUrl(){
        return this.url;
    }

    public void setUrl(String url){
        this.url = url;
    }

	public String getCate(){
        return this.cate;
    }

    public void setCate(String cate){
        this.cate = cate;
    }

	public String getDate(){
        return this.date;
    }

    public void setDate(String date){
        this.date = date;
    }

	public String getSrcfrom(){
        return this.srcfrom;
    }

    public void setSrcfrom(String srcfrom){
        this.srcfrom = srcfrom;
    }

	public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

	public String getEditor(){
        return this.editor;
    }

    public void setEditor(String editor){
        this.editor = editor;
    }

	public Long getOffset(){
        return this.offset;
    }

    public void setOffset(Long offset){
        this.offset = offset;
    }

	public Integer getLimit(){
        return this.limit;
    }

    public void setLimit(Integer limit){
        this.limit = limit;
    }

}