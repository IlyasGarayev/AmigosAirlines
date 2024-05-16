package ChainLogic;

public abstract class Chain {
    private Chain next;

    public void setNext(Chain next) {
        this.next = next;
    }

    public <T> void doNext(T obj){
        try{
            process(obj);
            if(next != null) {
                next.doNext(obj);
            }
            else{
                System.out.println("Something");
                // Proqrama uygun duzelderik
            }
        }
        catch(RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    public abstract <T> void process(T obj);
}
