## HtmlDocumentBuilder 
This is a simple readme for the HtmlDocumentBuilder project.

## Overview
The HtmlDocumentBuilder project is a small Java application that demonstrates the usage of the Builder pattern and encapsulation principles. It provides a convenient way to programmatically build an HTML document using a fluent API.

## How It Works
The HtmlDocumentBuilder class allows you to construct an HTML document step by step by creating elements, setting attributes, and adding content. Once you have built the desired structure, you can generate the corresponding HTML markup by calling the build() method.

Here's an example of how the HtmlDocumentBuilder can be used:

```java
HtmlDocumentBuilder hdb = new HtmlDocumentBuilder();
HtmlNode head = hdb.getHead();

// Building the head section
head
    .createChild("title")
    .setText("HtmlDocumentBuilder");

head
    .createChild("link")
    .withAutoclosing()
    .addAttributes(
        new HtmlAttributes("rel", "stylesheet"),
        new HtmlAttributes("href", "style.css")
    );

// Building the body section
HtmlNode body = hdb.getBody();
HtmlNode main = body.createChild("main");

main
    .createChild("h1")
    .addAttributes(
        new HtmlAttributes("id","title"),
        new HtmlAttributes("class", "text-lg", "text-blue-900")
    )
    .setText("hello world");

HtmlNode form = main.createChild("form");

String id = "fname";

form
    .createChild("label")
    .addAttributes(
        new HtmlAttributes("id", id)
    )
    .setText("first name :");

form
    .createChild("input")
    .withAutoclosing()
    .addAttributes(
        new HtmlAttributes("id", id),
        new HtmlAttributes("name", "fname"),
        new HtmlAttributes("type", "text"),
        new HtmlAttributes("placeholder","john doe"),
        new HtmlAttributes("required")
    );

form
    .createChild("input")
    .withAutoclosing()
    .addAttributes(
        new HtmlAttributes("type", "submit")
    );

// Generating the HTML markup
System.out.println(hdb.build());
```
       

The build() method of the HtmlDocumentBuilder generates the following HTML markup:

```html
<!DOCTYPE html>
<html>
<head>
    <title>HtmlDocumentBuilder</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
    <main>
        <h1 id="title" class="text-lg text-blue-900">hello world</h1>
        <form>
            <label id="fname">first name :</label>
            <input id="fname" name="fname" type="text" placeholder="john doe" required />
            <input type="submit" />
        </form>
    </main>
</body>
</html>
```
## Learning Benefits
Through working on this project, I had the opportunity to learn more about the Builder pattern, which provides a convenient and readable way to construct complex objects. The use of encapsulation principles ensures that the inner workings of the classes are hidden, making them easy to use and understand for other developers.

Overall, this project allowed me to improve my understanding of design patterns, encapsulation, and creating flexible and reusable code.