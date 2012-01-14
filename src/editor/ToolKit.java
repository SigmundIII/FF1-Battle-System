package editor;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class ToolKit extends JFrame{
	
	MapEditorGUI mapEditor;
	PassabilityEditor passabilityEditor;
	
	/*
	 * Dialogs
	 */
	NewMapDialog newMapDialog;
	JTabbedPane tabbedPane;
	
	static final String[] tileSets = buildTileMapList();
	
	
	public ToolKit()
	{
		setLayout(null);
		setSize(660, 480);
		setResizable(false);

		mapEditor = new MapEditorGUI();
		passabilityEditor = new PassabilityEditor();
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setSize(660, 480);
		tabbedPane.addTab("Map Editor", mapEditor);
		tabbedPane.addTab("Passability Editor", passabilityEditor);
		add(tabbedPane);
		
		setTitle("JFF1 Toolkit");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setVisible(true);
	}

	/**
	 * Creates a list of available tilemaps
	 * @return
	 */
	private static String[] buildTileMapList()
	{
		String[] s = new File("data/tilemaps").list(new FilenameFilter() {
            public boolean accept(File f, String s) {
                return s.endsWith(".png");
              }
            });
		return s;
	}
	
	/**
	 * Runner method
	 */
	public static void main(String[] args)
	{
		ToolKit g = new ToolKit();
	}
}
