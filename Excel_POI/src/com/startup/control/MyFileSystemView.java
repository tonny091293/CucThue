package com.startup.control;

import java.io.File;
import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

public class MyFileSystemView extends FileSystemView {

	private File root;

	public MyFileSystemView(File root) {
		super();
		try {
			this.root = root.getCanonicalFile();
		} catch (IOException e) {
			this.root = root;
		}
	}

	@Override
	public File[] getRoots() {
		return new File[] { root };
	}

	@Override
	public File createNewFolder(File containingDir) throws IOException {
		return FileSystemView.getFileSystemView()
				.createNewFolder(containingDir);
	}

	@Override
	public File createFileObject(String path) {
		File file = super.createFileObject(path);
		if (isEmbedded(file)) {
			return file;
		} else {
			return root;
		}
	}

	@Override
	public File createFileObject(File dir, String filename) {
		if (isEmbedded(dir)) {
			return super.createFileObject(dir, filename);
		} else {
			return root;
		}

	}

	@Override
	public File getDefaultDirectory() {
		return root;
	}

	private boolean isEmbedded(File file) {
		while (file != null && !file.equals(root)) {
			file = file.getParentFile();
		}
		return file != null;
	}

	@Override
	public File getParentDirectory(File dir) {
		File parent = dir.getParentFile();
		if (isEmbedded(parent)) {
			return parent;
		} else {
			return root;
		}
	}
}