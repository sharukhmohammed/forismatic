import sharukh.forismatic.Quote;
import sharukh.forismatic.QuoteBuilder;

public class Example
{
    public static void main(String[] args)
    {
        Quote test = new QuoteBuilder().getQuote();
        System.out.println(test.quoteText + " Author:" + test.quoteAuthor);
    }
}