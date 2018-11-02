public class Response extends Application{
	
	protected borderPane
	protected BorderPane getBorderpane(){
		BorderPane pane = new BorderPane();
		Button rbquote = new Button("quotes");
		Button rbreplies = new Button("quotes");
		Button rbquote = new Button("replies");
		Button rbquoandrep = new Button("quotes and replies");
		VBox paneForButtons = new VBox(20);
		paneForButtons.setPadding(new Insets(5,5,5,5));
		paneForButtons.getChildren().addAll(rbquote,rbreplies,rbquoandrep);
		ToggleGroup tg = new ToggleGroup();
		rbquote.setTogglegroup(tg);
		rbquote.setSelect(true);
		rbreplies.setTogglegroup(tg);
		rbquoandrep.setTogglegroup(tg);
		paneForButtons.getChildren().add();
		pane.setTopo(paneForButtons);
	}  
}