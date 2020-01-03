package ver0.village.Recycler;

public class RecyclerViewItemLend {
    private String title;
    private String name;
    private String price;
    private boolean isLike;

    public void setTitle(String title){
        this.title = title;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setIsLike(boolean isLike){
        this.isLike = isLike;
    }

    public String getTitle(){
        return this.title;
    }

    public String getName(){
        return this.name;
    }

    public String getPrice(){
        return this.price;
    }

    public boolean getIsLike(){
        return this.isLike;
    }
}
