package Code.Run;

/**CLASE PRINCIPAL DE LA APLICACION*/
public class Main {
 	public static String nameCorpus="corpus";
	public static String exfilter="java";
	public static void main(String [] args){
		/**MANDAMOS LLAMAR LA CLASE QUE REALIZA LA CREACION DEL ARCHIVO QUE CONTENDRA EL TEXTO DE LAS RELACIONES PROYECTO ASI COMO SU METODO PRINCIPAL*/
			FileRelations filerelations = new FileRelations();
			filerelations.ReadFile();
			String addressFile=filerelations.getAddressFile();/**CON ESTE METODO LE ENVIAMOS LA DIRECCION DE LA RUTA DONDE SE ENCUENTRA NUESTRO DOCUMENTO A ANALIZAR*/
			/**CON ESTE METODO LLAMAMOS LA CLASE "ConectionSQL Y LE ENVIAMOS COMO PARAMETOS EL USUARIO, LA CONTRASENA Y EL NOMBRE DE LA BASE DEATOS*/
			GateRunning relacion =new GateRunning(addressFile);
			Conexion conexion=new Conexion(filerelations.getUser(),filerelations.getPassword(),filerelations.getDBname());
			filerelations.crateFilesRelations();
			relacion.executeAnalisis(exfilter,nameCorpus);/**MANDAMOS LLAMAR EL METODO PARA ANALIZAR EL ARCHIVO*/
			conexion.OpenConection();/**LLAMAMOS EL METODO PARA ABRIR LA CONECCION A LA BASE DE DATOS*/
			conexion.insertData();/**LLAMAMOS EL METODO PARA INSERTAR DATOS EN LA BASE DE DATOS*/
			conexion.closeDB();/**LLAMAMOS EL METODO PARA CERRAR LA CONECCION A LA BASE DE DATOS*/

		}

}
