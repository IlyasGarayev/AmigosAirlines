package ChainLogic;

import User.User;

public abstract class Chain {
    private Chain next;
    private Chain previous;

    public void setPrevious(Chain previous) {
        this.previous = previous;
    }

    public void setNext(Chain next) {
        this.next = next;
    }

    public void doNext(User user){
        try{
            process(user);
            if(next != null) {
                next.doNext(user);
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
    // reverse


    public void doPrevious(User user){
        if(previous != null){
            previous.doNext(user);
        }
    }

    public abstract void process(User user);
}
