package ejercicios;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.tour.HeldKarpTSP;
import org.jgrapht.graph.SimpleWeightedGraph;

import tiposPI.Ciudad;
import tiposPI.Trayecto;
import us.lsi.graphs.GraphsReader;

public class Ejercicio3 {
	public static void apartadoA(Graph<Ciudad,Trayecto> g, String o, String d) {
		System.out.println("======================== APARTADO A ======================");
		g.edgeSet().forEach(a->g.setEdgeWeight(a,a.getCoste()));
		ShortestPathAlgorithm<Ciudad, Trayecto> alg = new DijkstraShortestPath<>(g);
		Ciudad from = Ciudad.create(o);
		Ciudad to = Ciudad.create(d);
		GraphPath<Ciudad,Trayecto> gp = alg.getPath(from, to);
		System.out.println("Lista de ciudades por las que hay que pasar para ir de " + from.toString() + " a "+ to.toString() + ": "+ gp.getVertexList()+
		"\n" + "Ruta más económica: " + gp.getWeight() + " euros"+ "\n" + 
		"Nº de carreteras: "+ gp.getLength()+ "\n");
		//Repeso el grafo, cambiando precio por tiempo
		g.edgeSet().forEach(a->g.setEdgeWeight(a,a.getTiempo()));
		alg = new DijkstraShortestPath<>(g);
		gp = alg.getPath(from, to);
		System.out.println("Lista de ciudades por las que hay que pasar para ir de " + from.toString() + " a "+ to.toString() + ": "+ gp.getVertexList()+
		"\n" + "Ruta más corta: " + gp.getWeight() + " minutos"+ "\n" + 
		"Nº de carreteras: "+ gp.getLength()+ "\n");
	}
	
	//================================Apartado A separado en 2==================================V
	//											V
	//											V
//	public static void rutaMasEconomica(Graph<Ciudad, Trayecto> g, String o, String d) {
//		System.out.println("======================== APARTADO A ======================");
//		ShortestPathAlgorithm<Ciudad, Trayecto> alg = new DijkstraShortestPath<>(g);
//		Ciudad from = Ciudad.create(o);
//		Ciudad to = Ciudad.create(d);
//		GraphPath<Ciudad,Trayecto> gp = alg.getPath(from, to);
//		System.out.println("Lista de ciudades: "+ gp.getVertexList());
//		System.out.println("Ruta más económica: " + gp.getWeight() + " euros");
//		System.out.println("Nº de carreteras: "+ gp.getLength());
//	}
//	public static void rutaMasCorta(Graph<Ciudad, Trayecto> g, String o, String d) {
//		System.out.println("======================== APARTADO A ======================");
//		ShortestPathAlgorithm<Ciudad, Trayecto> alg = new DijkstraShortestPath<>(g);
//		Ciudad from = Ciudad.create(o);
//		Ciudad to = Ciudad.create(d);
//		GraphPath<Ciudad,Trayecto> gp = alg.getPath(from, to);
//		System.out.println("Lista de ciudades: "+ gp.getVertexList());
//		System.out.println("Ruta más corta: " + gp.getWeight() + " minutos");
//		System.out.println("Nº de carreteras: "+ gp.getLength());
//	}
//===================================================================================================
	
	public static Graph<Ciudad, Trayecto> cargarGrafo(String nombreFichero) {
		return GraphsReader.newGraph(nombreFichero, Ciudad::create, Trayecto::create, ()->new SimpleWeightedGraph<Ciudad,Trayecto>(Ciudad::create,Trayecto::create), Trayecto::getCoste);
	}
	
	public static void apartadoB(Graph<Ciudad,Trayecto> g) {
		HeldKarpTSP<Ciudad, Trayecto> h = new HeldKarpTSP<>();
		try {
			System.out.println("El recorrido es: " + h.getTour(g).getVertexList()+ " con un coste de: " +h.getTour(g).getWeight() + " euros\n");
		}catch(Exception exc){
			System.out.println("No es posible recorrer todas las ciudades una sola vez volviendo a la misma");
		}
	}
	
	public static void apartadoC(List<Ciudad> ciudades, Graph<Ciudad,Trayecto>g) {
		List<Ciudad> ls= g.vertexSet().stream().collect(Collectors.toList());
		List<Ciudad> res = new ArrayList<>();
		List<Ciudad> recorrido = new ArrayList<>();
		Ciudad inicio= ls.get((int) (Math.random()*ls.size())); //No me dicen la ciudad origen, por lo tanto la supongo aleatoria
		double pes=0.;
		ShortestPathAlgorithm<Ciudad, Trayecto> alg = new DijkstraShortestPath<>(g);
		recorrido.add(inicio);
		recorrido.addAll(ciudades);
		recorrido.add(inicio);
		for (int i=0; i<recorrido.size()-1;i++) { //Recorro las ciudades por las que hay que pasar añadiendo origen y destino, y hago Dijkstra para cada tramo
			List<Ciudad> tmp= alg.getPath(recorrido.get(i), recorrido.get(i+1)).getVertexList();
			for (int x=0;x<tmp.size()-1;x++) { //No añado la última para que no salga el destino de una y el origen de la siguiente duplicadas en la lista
				res.add(tmp.get(x));
			}
			pes += alg.getPathWeight(recorrido.get(i), recorrido.get(i+1));
		}
		res.add(inicio); // Añado la última a mano, ya que no la añado en el bucle.
		System.out.println(res + " con un coste de " + pes + " euros pasando por "+ ciudades);
	}
}
