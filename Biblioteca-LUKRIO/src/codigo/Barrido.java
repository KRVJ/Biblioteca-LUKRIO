package codigo;

import java.awt.Image;
import java.io.File;

import javax.swing.JFileChooser;

public class Barrido {
	public void listarImagenes(){
		String direccion = null;
		JFileChooser chooser = new JFileChooser();
		File F=new File("c:/");  //Direccion principal donde se abrirá la ventana de busqueda.
		File NameDir = null,NamePath = null;
		int Checker;
		chooser.setCurrentDirectory(F);
		Checker = chooser.showOpenDialog(null);
		if(Checker==JFileChooser.APPROVE_OPTION){
			NameDir=chooser.getCurrentDirectory();
			NamePath=chooser.getSelectedFile();
			direccion=NamePath.getAbsolutePath();
			System.out.println(NameDir.getName());
			System.out.println((NamePath.getAbsolutePath().split(NameDir.getName()))[0]);
		}
		File directory;
	    File[]listFiles;
	    directory=new File((NamePath.getAbsolutePath().split(NameDir.getName()))[0]);
	    listFiles=directory.listFiles();
	    File imagenes2;
	    File[]listImages;
	    for(int i=0;i<listFiles.length;i++){
            try{
                imagenes2=new File(listFiles[i].getAbsolutePath());
                listImages=imagenes2.listFiles();
                System.out.println(listImages.length);
            }catch(Exception exception){
        }
      }
}
}