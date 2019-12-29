package ver0.village.Recycler;

public class RecyclerViewItemBorrow {
    private boolean isUrgent;
    private String title;
    private String name;

    public void setIsUrgent(boolean isUrgent){
        this.isUrgent = isUrgent;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean getIsUrgent(){
        return this.isUrgent;
    }

    public String getTitle(){
        return this.title;
    }

    public String getName(){
        return this.name;
    }
}
