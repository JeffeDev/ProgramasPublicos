package br.com.wmw.cleancode.excecoes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import br.com.wmw.cleancode.excecoes.tratamentodeerros.ErroArquivoNaoEncontradoException;
import br.com.wmw.cleancode.excecoes.tratamentodeerros.ErroDeLeituraException;
import br.com.wmw.cleancode.excecoes.tratamentodeerros.ErroException;

public class FileUtil {

	private FileUtil() {

	}

	public String loadFile(final String fileName) throws Exception  {
		final File fileToRead = new File(fileName);
		try {
			final InputStream inputStream = new FileInputStream(fileToRead);
			try {
				final StringBuilder conteudo = new StringBuilder();
				int data;
				while ((data = inputStream.read()) != -1) {
					conteudo.append((char) data);
				}
				return conteudo.toString();

			} finally {
				inputStream.close();
			}
		} catch (final FileNotFoundException e) {
			throw new ErroArquivoNaoEncontradoException(fileName, e);
		} catch (final IOException e) {
			throw new ErroDeLeituraException(fileName, e);
		} catch (final Exception e) {
			throw new ErroException(fileName, e);
		}

	}

}
