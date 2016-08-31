 This project aims to give students hands-on experience in designing and implementing a Web application on their own.

In recent years, researchers in academia have begun to generate an increasing amount of data in the course of their experimetns and observations. This data is of interest to other researchers for analysis, verification, and for building their effort on prior work in the field. Legislation also requires Universities to comply with rules that dictate retaining data for a number of years after a publication has appeared in a journal.

DBLP is a computer science bibliography website hosted at Universität Trier, in Germany. DBLP listed more than 3.4 million journal articles, conference papers, and other publications on computer science in July 2016. Following is a sample DBLP entry:

DBLP Sample Entry
You can download DBLP XML file and its DTD from this link: http://dblp.uni-trier.de/xml/

This assignment will use a subset of the DBLP for building an application that allows a user to discover information about available Computer Science Bibliography (e.g. authors, publications, venues, etc.), select particular publication, and add them to a "shopping cart". The user can add or delete items from the shopping cart at any time.
Requirements
1. DBLP Dataset

We will use the DBLP XML file, which follows a Simple DTD. The full XML file has more than 3 million publications. During development, you will need to work on a sample extract: you need to provide a sample that has around 20 thousand publications. We may test the application with any extract, which could also be larger that the one provided. However, during testing, the filename will remain the same as the one provided.

You will associate data such as search preferences and a "Shopping Cart" with a user using cookies and HTTP sessions. You should not use a login (user/password) for this purpose. Your application must have one and only one Servlet class. You can have other Java classes (e.g., beans and helpers). The web application has the following end points:
2. The Homepage

The starting/welcome page of your application, should display at the minimum a search bar allowing users to search for publications, authors, publication-type (e.g. Book, Journal, Conference, etc.), publication-date, and venues (e.g. BPM, VLDB, WWW, etc.). Additionally, you should also provide to the users the ability to perform advanced search based on more specific search preferences. The welcome page should also display a list (approx. 10 items) chosen at random.
3. Search

The user starts at the search page (that is, the starting/Welcome URL of the application is /search). This forwards to "search.jsp" which has a form with the following elements:

    text fields to search for publications, authors, venues etc.;
    a submit button labelled "Search";
    And, a link to the Shopping Cart page;

4. Search Results

instructions:

    The search functions forwards the users to the results page ("results.jsp"). The page has a list of entries that matched the search criteria, a submit button, and a link to the user's Shopping Cart;
    If the search has turned up empty, the results page must display "Sorry, no matching datasets found!";
    Otherwise, the results page displays a title for each entry (e.g. title, author etc.). The title is a hyperlink to a page that gives full information about the entry (e.g. author, title, page, year, book-title, etc). This page contains an "Add to Cart" button. The entry is added to the user's Shopping Cart on clicking this button.
    The results page should show only 10 results at a time. If there are more than 10 results then, at the bottom of the page are two navigation links Previous and Next that allow the user to navigate the results 1 page at a time. Ensure that the Previous and Next links are not shown on the first page and the last page of results respectively.

5. Shopping Cart

instructions:

    The Shopping Cart page can be opened by the user at any time by clicking on the links from the search form and the results page. The Shopping Cart page is a list of entry titles with a checkbox next to each title, and "Remove from Cart" and "Back to Search" buttons at the bottom of the page.
    The user can remove entries from his/her Shopping Cart by selecting the checkboxes and clicking the "Remove from Cart" button.
    If the user's Shopping Cart is empty, then the page must display "Shopping Cart is Empty!", followed by a "Back to Search" button.
    The Back to Search button takes the user back to the search form/ welcome page.

