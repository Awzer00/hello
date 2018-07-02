package com.project.web;

/*程序说明：
 * 该程序利用数值分析中的差值原理实现图像的扭曲变形，变形效果为图像中央似黑洞扭曲坍塌
 * 图形界面显示，支持多种常见图片格式，支持彩色图像变换，用户可以随意打开和保存变换后的图片
 * 程序核心函数为insert()
 * 作者 周欢*/
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImgChange extends JFrame {
	int w,h;	//图像大小： w为宽，h为高
	int r,x1,y1;//变换区域半径r，目标坐标点的源点坐标（x1,y1）
	int showx,showy;//视图框大小
	double d,c=0.06,e=2000,dp,drag,dragstep;//目标点离圆心距离d，凹陷变换系数c，扭曲变换系数e，扭曲参数drag
	//源始点里圆心距离dp，扭曲变换系数增量dragstep
	int[] temp;//图像缓存数组
	int[] deal;//处理后图像数组

	JPanel panel;	//图形界面布局
	JLabel lbl;		//图像显示标签
	JSlider slider;	//扭曲程度滑动条
	JButton btnFile;	//打开文件按钮
	JButton btnChange;	//图像变换按钮
	JButton btnSave;	//图像保存按钮
	Container content;	//界面容器
	String fileName;	//文件路径
	Image image;		//图像对象
	public ImgChange()//初始化
	{
		 super("自81周欢_数值黑洞");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 panel=new JPanel();
		 btnFile=new JButton("选择图片");
		 btnChange=new JButton("图像变换");
		 btnSave=new JButton("保存图像");
		 slider=new JSlider(JSlider.HORIZONTAL,0,10,3);//滑动条从0到10可调，初始为3
		 slider.setPaintTicks(true);
		 slider.setMajorTickSpacing(1);
		 slider.setMinorTickSpacing(10);
		 slider.setPaintLabels(true);
		 slider.setBorder(new javax.swing.border.TitledBorder(BorderFactory.createEmptyBorder(),"变形程度"));
		 slider.setEnabled(false);//未打开文件前滑动条不可用
		 btnChange.setEnabled(false);btnSave.setEnabled(false);//未打开文件前 图像变换和保存按钮不可用
		 
		 ImageIcon imgicon=new ImageIcon("welcom.jpg");
		 lbl=new JLabel(imgicon);
		 
		 content=getContentPane();
		 panel.add(btnFile);panel.add(btnChange); panel.add(btnSave);panel.add(slider);
		 btnFile.addActionListener(new ButtonActionListener());	//增加事件监听器
		 btnChange.addActionListener(new ButtonActionListener());
		 btnSave.addActionListener(new ButtonActionListener());
		 slider.addChangeListener(new valueChangeListener());
		 
		 content.add(lbl,BorderLayout.CENTER);	//布局
		 content.add(panel,BorderLayout.SOUTH);
		 setSize(800,500);
		 setVisible(true);
	}
	public void fileSelect()	//打开文件选择
	{
		JFileChooser chooser=new JFileChooser();
		FileNameExtensionFilter filter=new FileNameExtensionFilter("图片文件","jpg","png","gif");
		chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setCurrentDirectory(new File("."));
		int result=chooser.showOpenDialog(this);	
		if(result==JFileChooser.APPROVE_OPTION)
		{
			fileName=chooser.getSelectedFile().getAbsolutePath();
			loadImage(fileName);	//载入图像
			btnChange.setEnabled(true);
			setTitle("自81周欢_数值黑洞图像变换_"+chooser.getSelectedFile().getName());
		}
	}
	public void loadImage(String fileName)	//载入图像
	{
		ImageIcon image=new ImageIcon(fileName);
		if(image.getIconWidth()>image.getIconHeight())	//根据图像宽高确定图像显示大小
		{
			showx=800;
			showy=800*image.getIconHeight()/image.getIconWidth();
		}
		else
		{
			showy=500;
			showx=500*image.getIconWidth()/image.getIconHeight();
		}
		ImageIcon imgicon=new ImageIcon(image.getImage().getScaledInstance(showx,showy,Image.SCALE_DEFAULT));
		lbl.setIcon(imgicon) ;
	}
	
	class ButtonActionListener implements ActionListener //按钮事件监听器
	{
		
		public void actionPerformed(ActionEvent e)
		{
			JButton button=(JButton)e.getSource();
			if(button==btnFile)	//打开文件
			{fileSelect();slider.setEnabled(false);}
			else if(button==btnChange)	//图像变换
			{
				imgChange();
				slider.setValue(3);
				btnSave.setEnabled(true);
				slider.setEnabled(true);
			}
			else if(button==btnSave)	//图像保存
			{
				saveImage(createImage(deal));
			} 
		}
	}
	class valueChangeListener implements ChangeListener	//滑动条监听器
	{
		public void stateChanged(ChangeEvent ce)
		{
			int value=((JSlider)ce.getSource()).getValue();			
			c=(double)value/50;	//改变图像形变参数
			e=500*9/Math.sqrt(value);
			imgChange();	//调用图像变换方法
		}
	}
	public void imgChange()	//图像变换
	{
		ImageIcon image=new ImageIcon(fileName);
		w=image.getIconWidth();//获取图像信息
		h=image.getIconHeight();
		handlepixels(image.getImage(),0,0,w,h);//抓取图像像素
		insert();								//插值
		Image newImg=createImage(deal);		
		ImageIcon imgicon=new ImageIcon(newImg.getScaledInstance(showx,showy,Image.SCALE_DEFAULT));
		lbl.setIcon(imgicon) ;		//更新图像显示
	}
	public Image createImage(int[] colors){	//根据图像像素数组生成图像
	     JFrame jf=new JFrame();
	        Image modImg = jf.createImage(
	              new MemoryImageSource(            
	             w,h,colors,0,w));
	        return modImg;
	    }	
	public void saveImage(Image image)	//保存图像
	{   
		String tagetname;
		JFileChooser chooser=new JFileChooser();
		FileNameExtensionFilter filter=new FileNameExtensionFilter("图像文件","jpg","png","gif");
		chooser.setFileFilter(filter);
		int returnVal=chooser.showSaveDialog(this);
		if(returnVal==0)
		{tagetname=chooser.getCurrentDirectory().toString()+"\\"+chooser.getSelectedFile().getName();
		
		java.awt.image.BufferedImage bi = new java.awt.image.BufferedImage(w, h, java.awt.image.BufferedImage.TYPE_INT_BGR);
		Graphics2D g2= (Graphics2D)bi.getGraphics();
		g2.drawImage(image,0,0,null);
		
		try{
		 javax.imageio.ImageIO.write(bi, "JPEG", new java.io.File(tagetname));
		}catch(Exception e){
		 e.printStackTrace();
		}       
		}
		else
			return;
	 }

	public void handlepixels(Image img, int x, int y, int w, int h)	//抓取图像像素
	{
        int[] pixels = new int[w * h];
        deal=new int[w*h];

        PixelGrabber pg = new PixelGrabber(img, x, y, w, h, pixels, 0, w);
        temp=pixels;
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
            System.err.println("interrupted waiting for pixels!");
            return;
        }
        if ((pg.getStatus() & ImageObserver.ABORT) != 0) {
            System.err.println("image fetch aborted or errored");
            return;
        }
    }
	
	public void insert()	//插值
	{
		r=w>h? (h-10)/2:(w-10)/2;	//获取变形半径
        int i,j;
        int[] chpixel=new int[4];
		for (j = 0; j < h; j++) {	//两重循环逐个扫描像素点
            for (i = 0; i < w; i++) {
            	d=Math.sqrt((j-h/2)*(j-h/2)+(i-w/2)*(i-w/2));	//目标像素点离图像中心点距离
            	if(d>r)	//如果在图像处理部分之外则保存原来像素
            		deal[j*w+i]=temp[j*w+i];
            	else
            		{
            			dp=(c*r+d)/(1+c);	//获取源像素点离中心距离
            			drag=Math.asin(Math.abs(h/2-j)/d);	       	//获取目标像素点和中心点之间的角度    即扭曲参数		
	           			dragstep=Math.PI*(r-d)/e;		//扭曲参数增量随半径减小而增大
	           			if((w/2-i>0 || w/2-i==0)&& h/2-j>0)	//分别按四个坐标区域处理目标像素点的值
	           			{
	           				drag=drag-dragstep;	//扭曲参数变换
	           				x1=(int)Math.ceil((w/2-dp*Math.cos(drag)));	//获取源像素点横坐标
	           				y1=(int)Math.ceil((h/2-dp*Math.sin(drag)));	//获取源像素点纵坐标
	           				chpixel[0]=temp[y1*w+x1];	//分别获取相邻四个像素点的值
	           				chpixel[1]=temp[(y1-1)*w+x1];
	           				chpixel[2]=temp[(y1-1)*w+x1-1];
	           				chpixel[3]=temp[y1*w+x1-1];
	           			}
	           			else if(w/2-i<0 && (h/2-j>0 || h/2-j==0)){	//同上
	           				drag=drag+dragstep;
	           				x1=(int)Math.ceil((w/2+dp*Math.cos(drag)));
	           				y1=(int)Math.ceil((h/2-dp*Math.sin(drag)));
	           				chpixel[0]=temp[y1*w+x1];
	           				chpixel[1]=temp[(y1-1)*w+x1];
	           				chpixel[2]=temp[(y1-1)*w+x1+1];
	           				chpixel[3]=temp[y1*w+x1+1];
	           			}
	           			else if(w/2-i>0 && (h/2-j<0 || h/2-j==0)){
	           				drag=drag+dragstep;
	           				x1=(int)Math.ceil((w/2-dp*Math.cos(drag)));
	           				y1=(int)Math.ceil((h/2+dp*Math.sin(drag)));
	           				chpixel[0]=temp[y1*w+x1];
	           				chpixel[1]=temp[(y1+1)*w+x1];
	           				chpixel[2]=temp[(y1+1)*w+x1-1];
	           				chpixel[3]=temp[y1*w+x1-1];
	           			}
	           			else{
	           				drag=drag-dragstep;
	           				x1=(int)Math.ceil((w/2+dp*Math.cos(drag)));
	           				y1=(int)Math.ceil((h/2+dp*Math.sin(drag)));
	           				chpixel[0]=temp[y1*w+x1];
	           				chpixel[1]=temp[(y1+1)*w+x1];
	           				chpixel[2]=temp[(y1+1)*w+x1+1];
	           				chpixel[3]=temp[y1*w+x1+1];
	           			}
	           			deal[j*w+i]=handlesinglepixel(chpixel);	//对像素点进行插值 获取目标像素点的值
            		}
            }
		}
	}
	
	public int handlesinglepixel(int[] pixel)	//对像素点进行插值
	 {	
		int CHpixel;
		int[] alpha=new int[4];
		int[] red=new int[4];
		int[] green=new int[4];
		int[] blue=new int[4];
		for(int i=0;i<4;i++)	//分别获取相邻四个像素点的值
		{
			  alpha[i] = (pixel[i] >> 24) & 0xff; 
		      red[i]   = (pixel[i] >> 16) & 0xff;        
		      green[i] = (pixel[i] >>  8) & 0xff;
		      blue[i]  = (pixel[i]      ) & 0xff;
		     
		}
		CHpixel=((alpha[0]+alpha[1]+alpha[2]+alpha[3])/4)<<24 |		//对相邻四个点进行一次平均插值
		((red[0]+red[1]+red[2]+red[3])/4)<<16 |
		((green[0]+green[1]+green[2]+green[3])/4)<<8 |
		((blue[0]+blue[1]+blue[2]+blue[3])/4); 
		return CHpixel;				                       
	}
	
	public static void main(String[] args)
	{
		ImgChange objIC=new ImgChange();
	}
}
