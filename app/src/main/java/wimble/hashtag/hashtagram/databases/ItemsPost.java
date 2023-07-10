package wimble.hashtag.hashtagram.databases;

public class ItemsPost {
    private String category;
    private int id;
    private String image;
    private String name;
    private String tags;

    public ItemsPost(int i, String str, String str2, String str3, String str4) {
        this.id = i;
        this.name = str;
        this.image = str2;
        this.category = str3;
        this.tags = str4;
    }

    public ItemsPost(String str, String str2) {
        this.name = str;
        this.tags = str2;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }

    public String getCategory() {
        return this.category;
    }

    public String getTags() {
        return this.tags;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTags(String str) {
        this.tags = str;
    }
}
