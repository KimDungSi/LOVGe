package GameElements;

import lib.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javafx.scene.image.ImageView;
import Controller.GamePlayController;
import javafx.scene.layout.AnchorPane;
import java.util.*;

public class ListImage {
	
	ArrayList<ValueImage> list = new ArrayList<ValueImage>();

	public void addImage_to_List(ArrayList<ValueImage> list,ValueImage valueImage){
		ValueImage temp = valueImage;
		list.add(temp);
		System.out.println("Add to List"+list.size());
	}
	
	public int checkType(int type) {
		return type;
	}
	
	public Entity getEntityfromList(ArrayList<ValueImage> list,int index) {
		return (new Entity(list.get(index).imageView,list.get(index).widthImage,list.get(index).heighImage));
	}
	
	public void check_and_remove(ArrayList<ValueImage> list,AnchorPane pane) {
		int numImage = list.size();
		//System.out.println("Start Check"+ numImage);
//		for(int i=0;i<numImage-2;++i) {
//			for(int j=i+1;j<numImage-1;++j) {
//				Entity entity1 = this.getEntityfromList(i);
//				Entity entity2 = this.getEntityfromList(j);
//				Entity runAble = new Entity();
//				if(!runAble.hasVaCham(entity1,entity2))
//					continue;
//				if(checkType(list.get(i).typeImage)==1) {
//					pane.getChildren().remove(runAble.getImageView(entity1));
//					--numImage;	
//					list.remove(i);
//					System.out.println("Remove");
//				}
//				if(checkType(list.get(j).typeImage)==1) {
//					pane.getChildren().remove(runAble.getImageView(entity2));
//					--numImage;
//					list.remove(i);
//					System.out.println("Remove");
//				}
//			}
//		}
	}

	public ArrayList<ValueImage> getList() {
		return list;
	}

	public void setList(ArrayList<ValueImage> list) {
		this.list = list;
	}
	
	

}
