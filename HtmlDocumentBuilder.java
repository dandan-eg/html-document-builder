package htmldocumentbuilder;

class HtmlDocumentBuilder {
	private HtmlNode root;
	private HtmlNode head;
	private HtmlNode body;

	public HtmlDocumentBuilder() {
		this.root = new HtmlNode(0, "html");
		this.head = root.createChild("head");
		this.body = root.createChild("body");
	}

	public HtmlNode getHead() {
		return head;
	}

	public HtmlNode getBody() {
		return body;
	}

	public String build() {
		return "<!DOCTYPE html>" + System.lineSeparator() + root.toString();
	}

}
