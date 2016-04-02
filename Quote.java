package sharukh.forismatic;

public class Quote
{
    public String rawJsonString;
    public String quoteText;
    public String quoteAuthor;
    public String senderName;
    public String senderLink;
    public String quoteLink;

    @Override
    public String toString()
    {
        return rawJsonString;
    }
}
