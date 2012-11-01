/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import br.com.projeto.entity.Jogo;

/**
 *
 * @author Slipmp
 */
public class JogoDados 
{

    private final String NOME_JOGO="JogoMackDragonCity.serializado";
    /**
     * Esse metodo atualmente esta gravando um arquivo serializado na raiz do Jogo.
     * Observações:
     * 1° Esse método pode ser facilmente substituido para gravação em um banco de dados por Exemplo.
     * 2° Também está fixo apenas 1 Jogo para leitura e 1 Jogo para gravação.
     * 3° Foi feito dessa forma para simplificar o MackDragonCity, mas também é possivel
     * criar tela de login, criar vários jogos etc...
     * 4° Pensei em criar a serialização via XML, não ia dificultar tanto, mas como esse já está funcionando
     * nem cheguei a fazer. Seria apenas para ficar "legivel" o arquivo caso alguem quisesse abri-lo. 
     */
    public void GravarJogo(Jogo oJogo) throws Exception
    {
        try
        {
            FileOutputStream oFileOutputStream = new FileOutputStream(NOME_JOGO);
            ObjectOutputStream oObjectOutputStream = new ObjectOutputStream(oFileOutputStream);
            oObjectOutputStream.writeObject(oJogo);
            oObjectOutputStream.close();
        }
        catch (Exception ex)
        {
            throw new Exception("Erro ao gravar o Jogo!: " + ex.toString());
        }
    }
    
    public Jogo LerJogo() throws Exception
    {
        try
        {
            FileInputStream oFileInputStream = new FileInputStream(NOME_JOGO);
            
            ObjectInputStream oObjectInputStream = new ObjectInputStream(oFileInputStream);
            Jogo oJogo = (Jogo) oObjectInputStream.readObject();
            oObjectInputStream.close();
            return oJogo;
        }
        catch (StreamCorruptedException ex)
        {
            //Caso o arquivo esteja com uma versão mais antiga, ele não vai conseguir deserializar.
            //Então deve-se ignorar o arquivo e criar um novo.
            //também é possivel que o Arquivo esteja comrropido pelo Usuário, 
            //abrindo no notepad por exemplo e mudando algum valor.
            return null;
        }
        catch (FileNotFoundException ex)
        {
            //Caso o arquivo não exista.
            return null;
        }
        catch(InvalidClassException ex)
        {
            //Caso o arquivo esteja com uma versão mais antiga, ele não vai conseguir deserializar.
            //Então deve-se ignorar o arquivo e criar um novo.
            //também é possivel que o Arquivo esteja comrropido pelo Usuário, 
            //abrindo no notepad por exemplo e mudando algum valor.
            return null;
        }
        catch (Exception ex)
        {
            throw new Exception("Erro ao ler o Jogo!: " + ex.toString());
        }
    }
  
}
