package mythical;

public abstract class MythicalBeast {

    String name;

    public MythicalBeast(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}