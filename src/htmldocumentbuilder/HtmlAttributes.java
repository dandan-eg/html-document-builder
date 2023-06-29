package htmldocumentbuilder;

public class HtmlAttributes {
	private String key;
	private String[] values;
	
	public HtmlAttributes(String key) {
		this.key = key;
		this.values = null;
	}
	
	
	public HtmlAttributes(String key, String ...value) {
		this.key = key;
		this.values = value;
	}
	
	@Override
	public String toString() {
		if (values == null) {
			return key;
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%s=\"", key));
		for (int i = 0; i < values.length; i++) {
			sb.append(values[i]);
			
			boolean needSpaceAfter = i != values.length-1;
			if(needSpaceAfter) {
				sb.append(" ");
			}
		}
		
		sb.append("\"");
		
		
		return sb.toString();
	}
	
	
}
