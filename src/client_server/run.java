package client_server;


import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.InputNotAnIntegerException;
import model.Veiculo;

public class run {
	public static void main(String[] args) {
		  Client client = new Client();
		 Protocol protocol =  new Protocol();
			int x = 0;
			Scanner ler = new Scanner(System.in);
		 
		protocol.inserir(20737520587l, new Veiculo("Lotus Elan S-2 1.6 16V", 20737520587l,"MYW-7312",1995,"Diogo Pedro Henrique Joaquim Rocha", "521.584.994-35"));
		protocol.inserir(54312072502l, new Veiculo("Pontiac Trans-Sport SE 3.1 ", 54312072502l,"MYY-6935",1991,"Helena Andreia Moraes", "212.187.624-38"));
		protocol.inserir(16603954150l, new Veiculo("Mercedes-Benz E-320 3.2 Elegance", 16603954150l,"MXY-9623",1993,"Marcos Vinicius Baptista", "238.745.704-87"));
		protocol.inserir(49718905973l, new Veiculo("Bugre Buggy IV e V", 49718905973l,"MXY-9663",1985,"Vinicius Jorge Davi da Cruz", "588.987.534-54"));
		protocol.inserir(37352990235l, new Veiculo("Plymouth Gran Voyager LE 2.5", 37352990235l,"JJY-2942",1992,"Elisa Isadora Bernardes", "115.027.844-75"));
		protocol.inserir(15798734599l, new Veiculo("Nissan Sentra UNIQUE 2.0 Flex Fuel 16V Aut.", 15798734599l,"MWT-0888",2012,"Erick Renato Ruan Nunes", "485.568.134-29"));
		protocol.inserir(45811369870l, new Veiculo("SSANGYONG ACTYON SPORTS 2.0 16V 141cv Diesel", 45811369870l,"JNO-9228",2007,"Nathan Davi Marcos Vinicius da Rocha", "631.692.924-20"));
		protocol.inserir(11513830931l, new Veiculo("Mahindra SCORPIO 2.6 CD TB Diesel CRDe 4x4", 11513830931l,"HPX-0841",1965,"Fábio Yago Pires", "039.569.144-30"));
		protocol.inserir(42109350303l, new Veiculo("CHANGAN MINI STAR CE 1.0", 42109350303l,"LLU-7184",2011,"Laura Elaine da Mota", "823.627.144-70"));
		protocol.inserir(89751456219l, new Veiculo("Asia Motors Towner Super Luxo", 89751456219l,"GIM-9419",1997,"Levi Sebastião Ferreira", "749.034.624-04"));
		protocol.inserir(83393309781l, new Veiculo("Kia Motors Besta Furg ", 83393309781l,"KBL-2443",1991,"Oliver Filipe Fernando da Rocha", "878.188.534-21"));
		protocol.inserir(41433850059l, new Veiculo("Envemo Master 4.0 Diesel", 41433850059l,"LCR-2025",2011,"Arthur Bento Ramos", "413.801.164-14"));
		protocol.inserir(13458095950l, new Veiculo("Agrale", 13458095950l,"HTN-8267",2013,"Lucca Pietro Theo Alves", "356.858.914-15"));
		protocol.inserir(63060918070l, new Veiculo("MARRU", 63060918070l,"HTN-8267",2016,"Daniel Bento Marcos das Neves", "202.744.824-10"));
		protocol.inserir(10017599226l, new Veiculo("HAFEI", 10017599226l,"MUE-5690",2019,"Luiza Allana Assunção", "733.364.614-99"));
		protocol.inserir(78524653522l, new Veiculo("Towner Jr. Pick-up 1.0 8V 48cv  CD 4p", 78524653522l,"LGW-1312",2021,"Matheus Anthony Lopes", "544.232.384-54"));
		protocol.inserir(90815612368l, new Veiculo("Fibravan", 90815612368l,"ICM-5553",2001,"Manuela Isabelly Rebeca Lima", "594.348.134-68"));
		protocol.inserir(33855408890l, new Veiculo("Buggy Vip 1.8 8V", 33855408890l,"MRV-3816",2021,"Beatriz Daiane Caroline Oliveira", "071.048.754-17"));
		protocol.inserir(37477485130l, new Veiculo("SOUL 1.6/ 1.6 16V FLEX Aut.", 37477485130l,"MYO-0895",1999,"Marcela Tânia Duarte", "975.652.554-16"));
		protocol.inserir(39797259649l, new Veiculo("BMW 325i", 39797259649l,"MZG-5070",2003,"Antonio Caleb dos Santos", "351.687.724-39"));
		protocol.inserir(46111562170l, new Veiculo("Mercedes-Benz C-280 Touring", 46111562170l,"MXP-4316",2005,"Eloá Antônia Ferreira", "351.687.724-39"));
		protocol.inserir(59257583718l, new Veiculo("HAFEI Towner Pick_up Ba", 59257583718l,"MZD-1421",2006,"Gustavo Martin Luís Novaes", "635.803.144-91"));
		protocol.inserir(94134926429l, new Veiculo("Pontiac Trans-Sport SE 3.1", 94134926429l,"MUR-5012",2002,"Rosa Lavínia Nogueira", "935.079.544-27"));
		protocol.inserir(85069616735l, new Veiculo("Pointer GLi 2.0", 85069616735l,"HWY-2140",1987,"Leonardo Nelson Barros","952.771.694-23"));
		protocol.inserir(69761907472l, new Veiculo("Fox SELE", 69761907472l,"MVL-5804",2003,"Ian Davi Mendes", "120.001.334-44"));
		protocol.inserir(34005637230l, new Veiculo("Parati 1.8 Mi CROSSOVER Total Flex 8V 4p", 34005637230l,"HVC-9511",2004,"Emanuel Lucca Daniel Figueiredo", "750.121.404-27"));
		protocol.inserir(45038541661l, new Veiculo("Saveiro 1.6 Mi/ 1.6 Mi Total Flex 8V", 45038541661l,"LXX-4497",2023,"Davi Anthony Gabriel da Mota", "138.383.684-10"));
		protocol.inserir(62589791260l, new Veiculo("up! Run 1.0 Total Flex 12V 5p", 62589791260l,"NAK-0810",2020,"Roberto Vinicius Rafael Souza", "569.405.214-53"));
		protocol.inserir(98904186351l, new Veiculo("Parati 1.0 Mi FUN/ SunSet 16V 4p", 98904186351l,"JYA-6055",1999,"Gael Marcos Vinicius da Cruz", "683.768.274-13"));
		protocol.inserir(63600581274l, new Veiculo("Santana GLi / GL/ Sport 1.8/ 2.0", 63600581274l,"BTR-3401",2004,"Aurora Stefany Flávia Aragão", "015.207.304-38"));
		protocol.inserir(89129136433l, new Veiculo("Gol (novo) 1.0 Mi Total Flex 8V 2p", 89129136433l,"HVE-6904",2015,"Filipe André Caldeira", "522.347.074-55"));
		protocol.inserir(59129136433l, new Veiculo("Gol L 1.3/ L/ LS/ C/ S/ BX/ Plus 1.6", 59129136433l,"KAC-2565",1997,"César Ruan da Mata", "669.048.264-28"));
		protocol.inserir(54317872502l, new Veiculo("AMAROK Trendline CD 2.0 16V TDI 4x4 Dies", 54317872502l,"MZV-6244",2003,"Leandro Kevin Renato Santos", "600.168.844-34"));
		protocol.inserir(29985837339l, new Veiculo("SpaceCross I MOTION 1.6 Mi T. Flex 16V", 29985837339l,"IDB-4143",2022,"Cristiane Milena Francisca Moraes", "680.363.454-04"));
		protocol.inserir(52349039907l, new Veiculo("Polo Sedan 1.6 Mi Total Flex 8V 4p", 52349039907l,"NEI-8824",2001,"Analu Jaqueline Gonçalves", "481.168.924-01"));
		protocol.inserir(23490399079l, new Veiculo("Kombi LAST EDITION 56 1.4 Mi Total Flex", 23490399079l,"HPC-9532",2004,"Vitor Thiago da Rosa", "349.155.864-64"));
		protocol.inserir(33154868910l, new Veiculo("Gol TECH 1.0 Mi Total Flex 8V 2p", 33154868910l,"LWC-1750",2006,"Antonio Danilo Raimundo Teixeira", "046.938.914-10"));
		protocol.inserir(40699514842l, new Veiculo("SPACEFOX COMFORTLINE 1.6 Mi T.Flex 8V 5p", 40699514842l,"GYD-3752",2016,"Murilo Guilherme Mateus das Neves", "147.993.744-43"));
		protocol.inserir(88128012220l, new Veiculo("Eurovan 2.4 Diesel", 88128012220l,"NAZ-5345",1995,"Pietra Maya Teresinha Ribeiro", "681.281.724-41"));
		protocol.inserir(48761363666l, new Veiculo("Polo 2.0 Mi 116cv 8V 5p", 48761363666l,"NEY-8966",2015,"Jaqueline Luzia Luna Brito", "415.954.344-88"));
		protocol.inserir(10003072502l, new Veiculo("VOYAGE I MOTION  Trendline 1.6 T.Flex 8V", 10003072502l,"LVU-9466",2021,"316.020.294-15", "316.020.294-15"));
		protocol.inserir(49957720680l, new Veiculo("Envemo Master 4.0 Diesel",49957720680l ,"JJG-8782",1995,"Bento Mário Assis", "373.883.138-00"));
		protocol.inserir(62697031330l, new Veiculo("JeepGrand Cherokee Limited 3.6 4x4 V6 Aut.",62697031330l ,"HPT-6391",2011,"Isabel Lara Peixoto", "156.465.742-69"));
		protocol.inserir(77688715620l, new Veiculo("LIFAN X60 1.8 16V 128cv 5p Mec.X60",77688715620l ,"JUA-4399",2013,"Fábio Diogo Fogaça", "001.572.069-12"));
		protocol.inserir(97978690284l, new Veiculo("911 Carrera S Cabriolet 3.8 24V",97978690284l ,"JJO-8347",2012,"Evelyn Marcela Manuela Silveira", "478.531.451-60"));
		protocol.inserir(17671339618l, new Veiculo("TAC Stark 2.3 4WD 127cv TDI Diesel 3p",17671339618l ,"KDT-2995",2010,"Leandro Erick Thiago Almeida", "224.226.094-49"));
		protocol.inserir(59601377265l, new Veiculo("Troller RF Esport T-4 4x4 2.0 Cap. R",59601377265l ,"IAC-6433",1999,"Thomas Breno da Mota", "138.257.899-77"));
		protocol.inserir(78110126986l, new Veiculo("ASTON MARTIN Vantage S 6.0 V12 565cv",30976021643l ,"JTC-3752",2015,"Laura Elaine Adriana da Silva", "219.199.757-05"));
		protocol.inserir(83109184540l, new Veiculo("Troller T-4 4x4 3.0 TB Int. Cap. Lona Diesel ",83109184540l ,"HUW-4283",2006,"Isadora Ana Vanessa Sales", "834.545.236-13"));
		protocol.inserir(50655297959l, new Veiculo("MG 550 1.8 16V Turbo 170cv Aut.",50655297959l ,"HSB-2837",2010,"Mateus Caleb Yago da Paz", "581.687.187-04"));
        do {
			try{
            System.out.println("╔══════════════════════╗");
            System.out.println("║   Menu de Opções     ║");
            System.out.println("╠══════════════════════╣");
            System.out.println("║  1) - Entrar como    ║");
            System.out.println("║       cliente        ║");
            System.out.println("║  0) - Fechar o       ║");
            System.out.println("║       sistema        ║");
            System.out.println("╚══════════════════════╝");
            System.out.print("Escolha uma opção: ");
            x = ler.nextInt();
            ler.nextLine();

            switch (x) {
                case 1:
                    System.out.println("\nVocê selecionou 'Entrar como cliente'.");
                    client.client();
                    break;
                case 0:
                    System.out.println("\nFechando o sistema!!");
                    break;
                default:
                    System.out.println("\nOpção inválida");
                    break;
            }
            
            if (x != 0) {
                System.out.print("\nPressione Enter para continuar...");
                ler.nextLine();
            }
		}catch(InputMismatchException e){
            System.out.println("Entrada inválida. Digite um número inteiro.");
        }catch (InputNotAnIntegerException e) {
            System.out.println(e.getMessage());}
 
        } while (x != 0);
    }	
			
}


/*
 * 	
 */


