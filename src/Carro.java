/**
 * 
 * 
 * 
 *A classe Carro contém alguns métodos para o funcionamento do carro.
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
	 *Calcula a quantidade de combustivel presente no depósito.
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
	 * Consulta Quantidade de combustivel no depósito.
	 * @return retorna a quantidade de combustivel presente no depósito nesse momento
	 */

	public double getQuantidadeCombustivel() {
		return quantidadeCombustivel;
	}

	/**
	 *  Consulta a capacidade do depósito do carro.
	 * @return retorna o valor de capacidade de depósito
	 */
	public double getCapacidadeDeposito() {
		return capacidadeDeposito;
	}
	
	// Métodos 
	/**
	 * 
	 * @param quantidade valor para saber a quantidade que vai ser posta no depósito
	 * 
	 */
	public void meterCombustivel( double quantidade) { 		
		
		// Devia testar se Transborda o depósito
		// Podia retornar os Litros Metidos 
		quantidadeCombustivel = quantidadeCombustivel + quantidade;
		
		
	}
	
	/**
	 *  Serve para inserir combustivel no depósito.
	 *  Calcula os litros a meter para encher o depósito
	 * @return retorna os litro a meter no depósito
	 */
	// atestar o depósito
	public double meterCombustivel() {
		
		double litrosMeter = capacidadeDeposito - quantidadeCombustivel;
		
		// ou quantidadeCombustivel = capacidadeDeposito;
		meterCombustivel(litrosMeter);
		
		return litrosMeter;
	}
	
	
	/**
	 * Indica se o carro pode ou não andar.
	 * @param distancia valor para saber a distância que o carro irá percorrer
	 * @return retorna se o carro poderá andar consoante o combustivel que tenha e a distância que quer percorrer
	 */
	
	// distancia em klm
	public boolean andar( double distancia ) {
		
		// Verificar se tem combustivel para a distancia que se pretende andar 
		if( distancia < obterAutonomia() ) {
			
			quantidadeCombustivel -= getConsumo() * (distancia / 100); 
			return true;
		}
		else {
			
			// Aqui ou simplesmente não percorre qualquer distancia 
			// ou anda até parar porque fica sem combustível 
			return false;
		}
			
			
	} 
	/**
	 * Indica que o carro vai parar.
	 * @return retorna o valor true para a paragem do carro
	 */
	
	public boolean parar() {
		
		// se estiver a andar pára 
		// falta a flag que indica se o carro está em andamento
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
