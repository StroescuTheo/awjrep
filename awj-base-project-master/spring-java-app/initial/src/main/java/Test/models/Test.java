package test;

public class Test{

    private final long id;
	private final long x;
    private final String content;

    public Test(long id,long x, String content) {
        this.id = id;
		this.x=x;
        this.content = content;
    }

    public long getId() {
        return id;
    }
	    public long getX() {
        return x;
    }

    public String getContent() {
        return content;
    }
}
