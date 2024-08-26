package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController 
{
 public DistroController()
 {
  super();	 
 }
 
 public void os()
 {
  String os = System.getProperty("os.name");
  System.out.println(os);
  
  String proL = "cat /etc/os-release";
  if (os.contains("Linux"))
  {
	readProcess(proL);  
  } else
  {
	System.out.println("O Sistema Operacional não é Linux");  
  }
 }
 
 public void readProcess(String proc)
	{
	 String[] procvt = proc.split(" ");
	 try 
	 {
	  Process p = Runtime.getRuntime().exec(procvt);
	  InputStream fluxo = p.getInputStream();
	  InputStreamReader ler = new InputStreamReader(fluxo);
	  BufferedReader buffer = new BufferedReader(ler);
	  String linha = buffer.readLine();
	  while (linha != null)
	  {
		   
			System.out.println(linha); 
			linha = buffer.readLine();
			}
	   
	  buffer.close();
	  ler.close();
	  fluxo.close();
	 } catch (Exception e)
	   {
		System.out.println(""); 
	   }   
 }
}
