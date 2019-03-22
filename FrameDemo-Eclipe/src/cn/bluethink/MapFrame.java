package cn.bluethink;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import cn.bluethink.dto.GraphDTO;
import cn.bluethink.entity.GraphInfo;
import cn.bluethink.graph.GraphView;
import cn.bluethink.jframe.LoginJframe;
import cn.bluethink.jframe.RegisterJframe;
import cn.bluethink.util.DataUtil;
import cn.bluethink.util.JsonUtil;
import cn.bluethink.util.RestUtil;

public class MapFrame {

	private JFrame frame = new JFrame();
	GraphView canvas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapFrame window = new MapFrame();
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
					window.frame.setBounds(((int)dimension.getWidth() - 220) / 2, ((int)dimension.getHeight() - 320) / 2, 360, 260);
					window.frame.setVisible(true);
					DataUtil.jFrame = window.frame;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MapFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("BlueThink-Frame");
		frame.getContentPane().setFont(new Font("����", Font.PLAIN, 24));
		frame.setFont(new Font("����", Font.PLAIN, 24));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("����", Font.PLAIN, 24));
		frame.setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("�ļ�");
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("��ȡ");
		menuOpen.setIcon(new ImageIcon(MapFrame.class.getResource("/res/folder.gif")));
		menuOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (DataUtil.currentUser != null) {
					canvas.clear();
//					RestUtil.paramList.put("userid", DataUtil.currentUser.getUserId());
					List<GraphInfo> graphInfoList = RestUtil.graphList();
					if (graphInfoList != null && !graphInfoList.isEmpty()) {
						DataUtil.graphList(graphInfoList, canvas);
						canvas.repaint();
					}
				} else {
					LoginJframe login = new LoginJframe();
					DataUtil.jFrame = login.getjFrame();
				}
				
			}
			
		});
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("����");
		menuSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<GraphDTO> graphDTOList =  DataUtil.graphDTOList(canvas);
				if (!graphDTOList.isEmpty()) {
					if (DataUtil.currentUser != null) {
						graphDTOList.forEach(graphDTO -> {
							String jsonBody = JsonUtil.bean2Json(graphDTO);
							RestUtil.graphAdd(jsonBody);
						});
						canvas.clear();
					} else {
						LoginJframe login = new LoginJframe();
						DataUtil.jFrame = login.getjFrame();
					}
				}				
			}
			
		});
		menuFile.add(menuSave);
		
		JMenu menuGraph = new JMenu("ͼ��");
		menuBar.add(menuGraph);
		JMenuItem menuClear = new JMenuItem("���");
		menuClear.setIcon(new ImageIcon(MapFrame.class.getResource("/res/folder.gif")));
		menuClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.clear();
				canvas.refresh();
				canvas.repaint();
			}
			
		});
		menuGraph.add(menuClear);
		
		JMenu menuUser = new JMenu("�û�");
		menuBar.add(menuUser);
		
		JMenuItem menuRegister = new JMenuItem("ע��");
		menuRegister.setIcon(new ImageIcon(MapFrame.class.getResource("/res/folder.gif")));
		menuRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterJframe register = new RegisterJframe();
				DataUtil.jFrame = register.getjFrame();
			}
			
		});
		menuUser.add(menuRegister);
		
		JMenuItem menuLogin = new JMenuItem("��½");
		menuLogin.setIcon(new ImageIcon(MapFrame.class.getResource("/res/folder.gif")));
		menuLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginJframe login = new LoginJframe();
				DataUtil.jFrame = login.getjFrame();
			}
			
		});
		menuUser.add(menuLogin);
		
		JMenuItem exitLogin = new JMenuItem("�˳�");
		exitLogin.setIcon(new ImageIcon(MapFrame.class.getResource("/res/folder.gif")));
		exitLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (DataUtil.currentUser != null) {
					DataUtil.currentUser = null;
					JOptionPane.showMessageDialog(frame, "�˳��ɹ���","��ʾ", JOptionPane.INFORMATION_MESSAGE);	
				} else {
					JOptionPane.showMessageDialog(frame, "δ��¼��","��ʾ", JOptionPane.INFORMATION_MESSAGE);	
					LoginJframe login = new LoginJframe();
					DataUtil.jFrame = login.getjFrame();
				}				
			}
		});
		menuUser.add(exitLogin);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFont(new Font("����", Font.PLAIN, 24));
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnOpen = new JButton("");
		toolBar.add(btnOpen);
		btnOpen.setToolTipText("���ļ�");
		btnOpen.setIcon(new ImageIcon(MapFrame.class.getResource("/res/folder.gif")));
		
		JButton btnReset = new JButton("");
		toolBar.add(btnReset);
		btnReset.setToolTipText("ȫ����ʾ");
		btnReset.setIcon(new ImageIcon(MapFrame.class.getResource("/res/mapreset.png")));
		
		JButton btnZoomin = new JButton("");
		toolBar.add(btnZoomin);
		btnZoomin.setToolTipText("�Ŵ�");
		btnZoomin.setIcon(new ImageIcon(MapFrame.class.getResource("/res/mapzoomin.png")));
		
		JButton btnZoomout = new JButton("");
		toolBar.add(btnZoomout);
		btnZoomout.setToolTipText("��С");
		btnZoomout.setIcon(new ImageIcon(MapFrame.class.getResource("/res/mapzoomout.png")));
		
		JButton btnPan = new JButton("");
		toolBar.add(btnPan);
		btnPan.setToolTipText("����");
		btnPan.setIcon(new ImageIcon(MapFrame.class.getResource("/res/mappan.png")));
		
		JToolBar toolBarGraph = new JToolBar();
		toolBar.add(toolBarGraph);
		
		JButton btnGEditor = new JButton("");
		btnGEditor.setToolTipText("�༭");
		btnGEditor.setIcon(new ImageIcon(MapFrame.class.getResource("/res/editor.gif")));
		toolBarGraph.add(btnGEditor);
		btnGEditor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.mCurrentOp = "select";
			}
			
		});
		
		JButton btnGPoint = new JButton("");
		toolBarGraph.add(btnGPoint);
		btnGPoint.setIcon(new ImageIcon(MapFrame.class.getResource("/res/point.gif")));
		btnGPoint.setToolTipText("�ɼ���");
		
		JButton btnGLine = new JButton("");
		toolBarGraph.add(btnGLine);
		btnGLine.setIcon(new ImageIcon(MapFrame.class.getResource("/res/line.gif")));
		btnGLine.setToolTipText("�ɼ��߶�");
		btnGLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.mCurrentOp = "line";
			}
			
		});
		
		JButton btnGPolyline = new JButton("");
		toolBarGraph.add(btnGPolyline);
		btnGPolyline.setToolTipText("�ɼ�����");
		btnGPolyline.setIcon(new ImageIcon(MapFrame.class.getResource("/res/polyline.gif")));
		btnGPolyline.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.mCurrentOp = "polyline";
			}
		});
		JButton btnGPolygon = new JButton("");
		toolBarGraph.add(btnGPolygon);
		btnGPolygon.setToolTipText("�ɼ������");
		btnGPolygon.setIcon(new ImageIcon(MapFrame.class.getResource("/res/polygon.gif")));
		btnGPolygon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.mCurrentOp = "polygon";
			}
		});
		
		canvas = new GraphView();
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
		
		frame.addComponentListener(new ComponentAdapter(){
			@Override public void componentResized(ComponentEvent e){
				canvas.onSizeChanged();
			}});
	}

}
