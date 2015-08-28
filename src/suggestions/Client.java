
package suggestions;

public class Client
{
    private boolean turnstile;
    private int turnstileID;
    private int turnstileCounter;
    
    public Client(boolean turnstile, int turnstileID, int turnstileCounter) {
        this.turnstile = turnstile;
        this.turnstileID = turnstileID;
        this.turnstileCounter = turnstileCounter;
    }
    
    public boolean isTurnstile()
    {
        return turnstile;
    }
    
    public int getTurnstileID()
    {
        return turnstileID;
    }
    
    public int getTurnstileCounter()
    {
        return turnstileCounter;
    }
    
    public void setTurnstileCounter(int turnstileCounter)
    {
        this.turnstileCounter = turnstileCounter;
    }
}
