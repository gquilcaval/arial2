package vista;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartTheme;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import model.RoundedCornerBorder;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class IntDashBoard extends JInternalFrame {
	private JPanel pnlGcircular;
	private JPanel panelGBarra;
	private JPanel panel_4;
	private JPanel pnlBarraVende;
	private JPanel pnlBarraProd;
	private String colorPlomo="#808793";
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntDashBoard frame = new IntDashBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IntDashBoard() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				
				bcProductos();
				GbarraVentas();
				GbarraVendedorTop();
				GbarraProducStock();
				
			}
		});
	
		setBounds(100, 100, 1642, 901);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1626, 871);
		scrollPane.setBorder(null);
		getContentPane().add(scrollPane);
		
		panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setPreferredSize(new Dimension(1610,2000));
		panel_4.setBackground(Color.decode("#ebf0f4"));
		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(null);
		
		pnlBarraVende = new JPanel();
		pnlBarraVende.setBounds(81, 584, 687, 360);
		panel_4.add(pnlBarraVende);
		pnlBarraVende.setLayout(null);
		pnlBarraVende.setBorder(null);
		pnlBarraVende.setBackground(Color.WHITE);
		
		pnlGcircular = new JPanel();
		pnlGcircular.setBounds(1035, 73, 502, 456);
		panel_4.add(pnlGcircular);
		pnlGcircular.setLayout(null);
		pnlGcircular.setBorder(null);
		pnlGcircular.setBackground(Color.WHITE);
		
		panelGBarra = new JPanel();
		panelGBarra.setBounds(81, 73, 900, 456);
		panel_4.add(panelGBarra);
		panelGBarra.setLayout(null);
		panelGBarra.setBorder(null);
		panelGBarra.setBackground(Color.WHITE);
		
		pnlBarraProd = new JPanel();
		pnlBarraProd.setBounds(850, 584, 687, 360);
		panel_4.add(pnlBarraProd);
		pnlBarraProd.setLayout(null);
		pnlBarraProd.setBorder(null);
		pnlBarraProd.setBackground(Color.WHITE);
		
		lblNewLabel = new JLabel("En Construccion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 42));
		lblNewLabel.setBounds(400, 902, 750, 212);
		panel_4.add(lblNewLabel);

	}

	
	
	void GbarraVentas() {
		
		int cant1=11400;
		int cant2=24000;
		int cant3=12100;
		int cant4=14200;
		int cant5=11200;
		int cant6=14110;
		int cant7=11000;
		
		
		DefaultCategoryDataset ds=new DefaultCategoryDataset();
		ds.addValue(cant6, "", "Enero");
		ds.addValue(cant7, "", "Febrero");
		ds.addValue(cant1, "", "Marzo");
		ds.addValue(cant2, "", "Abril");
		ds.addValue(cant3, "", "Mayo");
		ds.addValue(cant4, "", "Junio");
		ds.addValue(cant5, "", "Julio");
		
		JFreeChart jf=ChartFactory.createBarChart3D("Ventas por mes", "Meses"	, "Cantidad Vendida Por Mes", ds,PlotOrientation.VERTICAL,false,false,false);
		 
	

		TextTitle textTitle=jf.getTitle();
		textTitle.setFont(new Font("SANSSERIF",Font.BOLD,20));
		textTitle.setPaint(Color.DARK_GRAY);
	
		CategoryPlot plot=jf.getCategoryPlot();
		plot.setBackgroundAlpha(0);
		
	  
		plot.setRangeGridlinePaint(Color.GRAY);
		BarRenderer renderer=(BarRenderer)plot.getRenderer();
		renderer.setSeriesPaint(0, new Color(15, 149, 236));
		
		ChartPanel cPanel=new ChartPanel(jf);
        panelGBarra.setLayout(new BorderLayout());
		panelGBarra.add(cPanel,BorderLayout.CENTER);
		panelGBarra.validate();
		
		
	}
	
	void bcProductos() {
		
	
		
		DefaultPieDataset ds = new DefaultPieDataset();
		ds.setValue("panadol", 40);
		ds.setValue("cetirizina", 30);
		ds.setValue("ibuprofeno", 10);
		ds.setValue("paracetamol", 55);
		ds.setValue("nastiflu", 80);
	
		
		JFreeChart jf=ChartFactory.createPieChart3D("Productos mas Vendidos", ds,true,true,false);
	
		TextTitle textTitle=jf.getTitle();
		textTitle.setFont(new Font("SANSSERIF",Font.BOLD,20));
		textTitle.setPaint(Color.DARK_GRAY);
		
		
		
		ChartPanel cPanel=new ChartPanel(jf);
        pnlGcircular.setLayout(new BorderLayout());
        pnlGcircular.add(cPanel,BorderLayout.CENTER);
        pnlGcircular.validate();
	}
	
	void GbarraVendedorTop() {
		
		int cant1=11400;
		int cant2=24000;
		int cant3=12100;
		int cant4=14200;
	
		
		
		DefaultCategoryDataset ds=new DefaultCategoryDataset();
		ds.addValue(cant1, "", "jorge");
		ds.addValue(cant2, "", "ernesto");
		ds.addValue(cant3, "", "alicia");
		ds.addValue(cant4, "", "arturo");
		
		
		JFreeChart jf=ChartFactory.createBarChart3D("Top Vendedores", "vendedores"	, "Cantidad Vendida Por Mes", ds,PlotOrientation.HORIZONTAL,false,false,false);
	
		CategoryPlot plot=jf.getCategoryPlot();
            plot.setBackgroundAlpha(0);
		
		
		plot.setRangeGridlinePaint(Color.GRAY);
		BarRenderer renderer=(BarRenderer)plot.getRenderer();
		renderer.setSeriesPaint(0, new Color(15, 149, 236));
		
		TextTitle textTitle=jf.getTitle();
		textTitle.setFont(new Font("SANSSERIF",Font.BOLD,20));
		textTitle.setPaint(Color.DARK_GRAY);
		ChartPanel cPanel=new ChartPanel(jf);
        pnlBarraVende.setLayout(new BorderLayout());
        pnlBarraVende.add(cPanel,BorderLayout.CENTER);
        pnlBarraVende.validate();
		
	}
	
	void GbarraProducStock() {
		
		int cant1=300;
		int cant2=200;
		int cant3=100;
		int cant4=50;
	
		DefaultCategoryDataset ds=new DefaultCategoryDataset();
		ds.addValue(cant4, "", "panadol");
		ds.addValue(cant3, "", "ibuprofeno");
		ds.addValue(cant2, "", "nastizol");
		ds.addValue(cant1, "", "cetirizina");
	
		
		JFreeChart jf=ChartFactory.createBarChart3D("Stock Productos", "Prodcutos"	, "", ds,PlotOrientation.HORIZONTAL,false,false,false);
		TextTitle textTitle=jf.getTitle();
		textTitle.setFont(new Font("SANSSERIF",Font.BOLD,20));
		textTitle.setPaint(Color.DARK_GRAY);
		CategoryPlot plot=jf.getCategoryPlot();
plot.setBackgroundAlpha(0);
		
		
		plot.setRangeGridlinePaint(Color.GRAY);
		BarRenderer renderer=(BarRenderer)plot.getRenderer();
		renderer.setSeriesPaint(0, new Color(15, 149, 236));
		
		ChartPanel cPanel=new ChartPanel(jf);
        pnlBarraProd.setLayout(new BorderLayout());
        pnlBarraProd.add(cPanel,BorderLayout.CENTER);
        pnlBarraProd.validate();
		
	}
}
