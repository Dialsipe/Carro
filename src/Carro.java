/**
 * 
 * 
 * 
 *A classe Carro cont�m alguns m�todos para o funcionamento do carro.
 * 	<ul>
 * 		<li>meterCombustivel</li>
 * 		<li>andar</li>
 * 		<li>parar</li>
 * 		<li>obterAutonomia</li>
 * 	</ul>
 * 	
 *		@author diogo
 */
public class Carro {
	
	/**
	 *Calcula a quantidade de combustivel presente no dep�sito.
	 *Calcula a autonomia.
	 *  
	 *  
	 */
	static private final double consumo=5.5; // litros por 100 klm
	
	private double quantidadeCombustivel;
	private double capacidadeDeposito;
	
	// Construtor por defeito 
	/**
	 *  Constructor por default
	 */
	public Carro() {
		super();
	
		quantidadeCombustivel = 0;
		capacidadeDeposito = 40.0;
	}
	
	// Acessores 
	/**
	* Consulta o consumo do Carro.
	* @return retorna o valor de consumo de um determinado carro
	*/
	public static double getConsumo() {
		return consumo;
	}
	
	/**
	 * Consulta Quantidade de combustivel no dep�sito.
	 * @return retorna a quantidade de combustivel presente no dep�sito nesse momento
	 */

	public double getQuantidadeCombustivel() {
		return quantidadeCombustivel;
	}

	/**
	 *  Consulta a capacidade do dep�sito do carro.
	 * @return retorna o valor de capacidade de dep�sito
	 */
	public double getCapacidadeDeposito() {
		return capacidadeDeposito;
	}
	
	// M�todos 
	/**
	 * 
	 * @param quantidade valor para saber a quantidade que vai ser posta no dep�sito
	 * 
	 */
	public void meterCombustivel( double quantidade) { 		
		
		// Devia testar se Transborda o dep�sito
		// Podia retornar os Litros Metidos 
		quantidadeCombustivel = quantidadeCombustivel + quantidade;
		
		
	}
	
	/**
	 *  Serve para inserir combustivel no dep�sito.
	 *  Calcula os litros a meter para encher o dep�sito
	 * @return retorna os litro a meter no dep�sito
	 */
	// atestar o dep�sito
	public double meterCombustivel() {
		
		double litrosMeter = capacidadeDeposito - quantidadeCombustivel;
		
		// ou quantidadeCombustivel = capacidadeDeposito;
		meterCombustivel(litrosMeter);
		
		return litrosMeter;
	}
	
	
	/**
	 * Indica se o carro pode ou n�o andar.
	 * @param distancia valor para saber a dist�ncia que o carro ir� percorrer
	 * @return retorna se o carro poder� andar consoante o combustivel que tenha e a dist�ncia que quer percorrer
	 */
	
	// distancia em klm
	public boolean andar( double distancia ) {
		
		// Verificar se tem combustivel para a distancia que se pretende andar 
		if( distancia < obterAutonomia() ) {
			
			quantidadeCombustivel -= getConsumo() * (distancia / 100); 
			return true;
		}
		else {
			
			// Aqui ou simplesmente n�o percorre qualquer distancia 
			// ou anda at� parar porque fica sem combust�vel 
			return false;
		}
			
			
	} 
	/**
	 * Indica que o carro vai parar.
	 * @return retorna o valor true para a paragem do carro
	 */
	
	public boolean parar() {
		
		// se estiver a andar p�ra 
		// falta a flag que indica se o carro est� em andamento
		return true;
	}
	
	/**
	 * Serve para obtermos a autonomia do carro.
	 * @return retorna a autonomia
	 */
	// kmCombustivel( )    
	public double obterAutonomia() {
		
		return ( quantidadeCombustivel / getConsumo() ) * 100;
		
	}

}
