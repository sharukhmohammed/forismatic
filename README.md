# Java Library for Forismatic

####Installation
Download the 'sharukh.forismatic.jar' and import in your project as JAR dependecy or add it in CLASSPATH

####Usage
initiate a new Quote object via constructor
> Quote quote = new QuoteBuilder().getQuote();

quote object contains quoteText,quoteAuthor,senderName,senderLink,quoteLink
>quote.quoteText //Gives quoteText


>quote.rawJsonString //Gives JSON String if required

#####you can play with it like a string
in command line
>System.out.print(quote.quoteAuthor+" says "+quote.quoteText);

or in your android project
>TextView.setText(quote.setText)
