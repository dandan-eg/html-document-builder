package htmldocumentbuilder;

import java.util.ArrayList;
import java.util.List;

public class HtmlNode {
	private static final String SPACE = "   ";

	private int indentation;
	private String element;
	private String text;
	private Boolean isAutoclosing = false;
	private List<HtmlAttributes> attributes;
	private List<HtmlNode> children;

	public HtmlNode(int indentation, String element) {
		this.element = element;
		this.indentation = indentation;
		this.attributes = new ArrayList<HtmlAttributes>();
		this.children = new ArrayList<HtmlNode>();
	}

	public HtmlNode withAutoclosing() {
		this.isAutoclosing = true;
		return this;
	}

	public HtmlNode createChild(String element) {
		HtmlNode child = new HtmlNode(indentation + 1, element);
		children.add(child);

		return child;
	}

	public HtmlNode setText(String text) {
		this.text = text;
		
		return this;
	}

	public HtmlNode addAttributes(HtmlAttributes... attributes) {
		for (HtmlAttributes a : attributes) {
			this.attributes.add(a);
		}

		return this;
	}

	private String getAttributesToString() {

		if (this.attributes.size() == 0) {
			return "";
		}

		// example str = [class="hello world", id="id"]

		String attrStr = attributes.toString();
		// remove ,
		attrStr = attrStr.replaceAll(",", "");

		// remove [ and ] at the beginning and the end
		return " " + attrStr.substring(1, attrStr.length() - 1);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String space = SPACE.repeat(indentation);

		sb.append(String.format("%s<%s%s", space, this.element, getAttributesToString()));

		if (this.isAutoclosing) {
			sb.append("/>\r\n");
			return sb.toString();
		}
		sb.append(">");

		if (this.text != null) {
			sb.append(this.text);
		} else {
			sb.append("\r\n");
			for (HtmlNode child : children) {
				sb.append(child.toString());
			}
			sb.append(space);
		}

		sb.append(String.format("</%s>\r\n", this.element));

		return sb.toString();

	}

}
