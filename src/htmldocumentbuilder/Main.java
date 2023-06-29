package htmldocumentbuilder;

public class Main {

	public static void main(String[] args) {
		HtmlDocumentBuilder hdb = new HtmlDocumentBuilder();
		HtmlNode head = hdb.getHead();
		
		//head
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
		
		
		//body
		HtmlNode body = hdb.getBody();		
		HtmlNode main = body.createChild("main");
		
		main
			.createChild("h1")
			.addAttributes(
					new HtmlAttributes("id","title"),
					new HtmlAttributes("class", "text-lg", "text-blue-900")
					)
			.setText("hello world");
		
		
		//form
		
		HtmlNode form = main
			.createChild("form");
		
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
		
		System.out.println(hdb.build());
	}
}
