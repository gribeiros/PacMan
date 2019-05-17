package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MyGdxGame extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;

	private float contador = 0;

	private Texture blockTexture;
	private Rectangle block;

	private Texture comidaTexture;
	private Rectangle comer;
	private ArrayList<Rectangle> comidas = new ArrayList<Rectangle>();

	private Texture pacmanA0;
	private Texture pacmanA1;
	private Texture pacmanA2;
	private Texture pacmanA3;
	public ArrayList<Texture> pacmanA = new ArrayList<Texture>();

	private Texture pacmanB0;
	private Texture pacmanB1;
	private Texture pacmanB2;
	private Texture pacmanB3;
	public ArrayList<Texture> pacmanB = new ArrayList<Texture>();

	private Texture pacmanC0;
	private Texture pacmanC1;
	private Texture pacmanC2;
	private Texture pacmanC3;
	public ArrayList<Texture> pacmanC = new ArrayList<Texture>();

	private Texture pacmanD0;
	private Texture pacmanD1;
	private Texture pacmanD2;
	private Texture pacmanD3;
	public ArrayList<Texture> pacmanD = new ArrayList<Texture>();
	private ArrayList<Rectangle> obstaculos = new ArrayList<Rectangle>();
	private Pacman pacman;

	private Rectangle pacmanR;

	/* Ghosts */
	private Texture blinky;
	private Rectangle blinkyR;

	private Texture clyde;
	private Rectangle clydeR;

	private Texture inky;
	private Rectangle inkyR;

	private Texture pinky;
	private Rectangle pinkyR;

	private int m[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 2, 2, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1, 0, 1, 2, 2, 2, 2, 2, 2, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 1, 1, 0, 1, 2, 2, 2, 2, 2, 2, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1, 0, 1, 2, 2, 2, 2, 2, 2, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1, 0, 1, 2, 2, 2, 2, 2, 2, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 768, 512);
		batch = new SpriteBatch();

		blockTexture = new Texture(Gdx.files.internal("barra.png"));
		comidaTexture = new Texture(Gdx.files.internal("comeu.png"));
		int x = 0;
		int y = 0;
		int k = 0;
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 24; j++) {
				if (m[i][j] == 1) {

					for (k = 0; k < j; k++) {
						x += 32;
					}

					block = new Rectangle();
					block.x = x;
					block.y = y;
					block.width = 32;
					block.height = 32;
					obstaculos.add(block);
					k = 0;
					x = 0;
					m[i][j] = 0;

				} else if (m[i][j] == 0) {
					comer = new Rectangle();
					comer.x = (j * 32) + 10;
					comer.y = y + 10;
					comer.width = 16;
					comer.height = 16;
					comidas.add(comer);
				}
			}
			y = y + 32;
		}
		renderizapacman();
		renderizaGhosts();
	}

	/* Render ghosts */
	private void renderizaGhosts() {
		blinky = new Texture(Gdx.files.internal("Blinky.png"));

		blinkyR = new Rectangle();
		blinkyR.x = getXYMap(9);
		blinkyR.y = getXYMap(7);
		blinkyR.width = 16;
		blinkyR.height = 16;

		clyde = new Texture(Gdx.files.internal("Clyde.png"));

		clydeR = new Rectangle();
		clydeR.x = getXYMap(11);
		clydeR.y = getXYMap(7);
		clydeR.width = 16;
		clydeR.height = 16;

		inky = new Texture(Gdx.files.internal("Inky.png"));

		inkyR = new Rectangle();
		inkyR.x = getXYMap(12);
		inkyR.y = getXYMap(7);
		inkyR.width = 16;
		inkyR.height = 16;

		pinky = new Texture(Gdx.files.internal("Pinky.png"));

		pinkyR = new Rectangle();
		pinkyR.x = getXYMap(14);
		pinkyR.y = getXYMap(7);
		pinkyR.width = 16;
		pinkyR.height = 16;

	}

	private void renderizapacman() {
		pacmanA0 = new Texture(Gdx.files.internal("pacman_0_0.png"));
		pacmanA1 = new Texture(Gdx.files.internal("pacman_0_1.png"));
		pacmanA2 = new Texture(Gdx.files.internal("pacman_0_2.png"));
		pacmanA3 = new Texture(Gdx.files.internal("pacman_0_3.png"));

		pacmanA.add(pacmanA0);
		pacmanA.add(pacmanA1);
		pacmanA.add(pacmanA2);
		pacmanA.add(pacmanA3);

		pacmanB0 = new Texture(Gdx.files.internal("pacman_1_0.png"));
		pacmanB1 = new Texture(Gdx.files.internal("pacman_1_1.png"));
		pacmanB2 = new Texture(Gdx.files.internal("pacman_1_2.png"));
		pacmanB3 = new Texture(Gdx.files.internal("pacman_1_3.png"));

		pacmanB.add(pacmanB0);
		pacmanB.add(pacmanB1);
		pacmanB.add(pacmanB2);
		pacmanB.add(pacmanB3);

		pacmanC0 = new Texture(Gdx.files.internal("pacman_2_0.png"));
		pacmanC1 = new Texture(Gdx.files.internal("pacman_2_1.png"));
		pacmanC2 = new Texture(Gdx.files.internal("pacman_2_2.png"));
		pacmanC3 = new Texture(Gdx.files.internal("pacman_2_3.png"));

		pacmanC.add(pacmanC0);
		pacmanC.add(pacmanC1);
		pacmanC.add(pacmanC2);
		pacmanC.add(pacmanC3);

		pacmanD0 = new Texture(Gdx.files.internal("pacman_3_0.png"));
		pacmanD1 = new Texture(Gdx.files.internal("pacman_3_1.png"));
		pacmanD2 = new Texture(Gdx.files.internal("pacman_3_2.png"));
		pacmanD3 = new Texture(Gdx.files.internal("pacman_3_3.png"));

		pacmanD.add(pacmanD0);
		pacmanD.add(pacmanD1);
		pacmanD.add(pacmanD2);
		pacmanD.add(pacmanD3);

		pacman = new Pacman();

		pacman.setPacman(pacmanA);

		pacmanR = new Rectangle();
		pacmanR.x = 480 / 2 - 8;
		pacmanR.y = 320 / 2;
		pacmanR.width = 16;
		pacmanR.height = 16;

	}

	private float guardaY, guardaX;
	private int naopassou = 0;
	private String direcao = "";

	@Override
	public void render() {

		Gdx.gl.glClearColor(0, 0, (float) 0.3, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();

		batch.setProjectionMatrix(camera.combined);

		int matrizX = getMatrizXY(pacmanR.x);
		int matrizY = getMatrizXY(pacmanR.y);

		int mapX = getXYMap(matrizX);
		int mapY = getXYMap(matrizY);

		System.out.println(matrizX + " " + matrizY);
		System.out.println(mapX + " " + mapY);

		batch.begin();
		for (Rectangle obstaculos2 : obstaculos) {
			batch.draw(blockTexture, obstaculos2.x, obstaculos2.y);
		}
		for (Rectangle comida : comidas) {
			if (comida.x != 1 && comida.y != 1) {
				batch.draw(comidaTexture, comida.x, comida.y);
			}
		}

		if (pacmanR.x != -50 && pacmanR.y != -50) {

			batch.draw(pacman.getPacman().get((int) contador % 4), pacmanR.x, pacmanR.y);
			batch.draw(blinky, blinkyR.x, blinkyR.y);
			batch.draw(clyde, clydeR.x, clydeR.y);
			batch.draw(inky, inkyR.x, inkyR.y);
			batch.draw(pinky, pinkyR.x, pinkyR.y);
			contador = (float) (contador + 0.05);

		} else {

		}
		batch.end();

		if (pacmanR.x != -50 && pacmanR.y != -50) {
			if (Gdx.input.isKeyPressed(Input.Keys.A)) {
				pacmanR.x -= 200 * Gdx.graphics.getDeltaTime();
				pacman.setPacman(pacmanC);
				direcao = "A";
			} else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
				pacmanR.x += 200 * Gdx.graphics.getDeltaTime();
				pacman.setPacman(pacmanA);
				direcao = "D";
			} else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
				pacmanR.y -= 200 * Gdx.graphics.getDeltaTime();
				pacman.setPacman(pacmanB);
				direcao = "S";
			} else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
				pacmanR.y += 200 * Gdx.graphics.getDeltaTime();
				pacman.setPacman(pacmanD);
				direcao = "W";
			}
		}

		for (Rectangle obstaculo : obstaculos) {
			if (pacmanR.overlaps(obstaculo)) {
				if (direcao.equals("A")) {
					if (pacmanR.x > obstaculo.x) {
						pacmanR.x = obstaculo.x + 32;
					}
				} else if (direcao.equals("D")) {
					if (pacmanR.x < obstaculo.x) {
						pacmanR.x = obstaculo.x - 16;
					}
				} else if (direcao.equals("W")) {
					if (pacmanR.y < obstaculo.y) {
						pacmanR.y = obstaculo.y - 16;
					}
				} else if (direcao.equals("S")) {
					if (pacmanR.y > obstaculo.y) {
						pacmanR.y = obstaculo.y + 32;
					}
				}
			}
		}

		for (Rectangle comida : comidas) {
			if (pacmanR.overlaps(comida)) {
				comida.x = 5;
				comida.y = 5;
			}
		}

		if (blinkyR.overlaps(pacmanR)) {
			pacmanR.x = -50;
			pacmanR.y = -50;
		}

		if (clydeR.overlaps(pacmanR)) {
			pacmanR.x = -50;
			pacmanR.y = -50;
		}

		if (inkyR.overlaps(pacmanR)) {
			pacmanR.x = -50;
			pacmanR.y = -50;
		}

		if (pinkyR.overlaps(pacmanR)) {
			pacmanR.x = -50;
			pacmanR.y = -50;
		}
	}

	private int getXYMap(float x) {
		int a = 12;

		if (x == 0) {
			return 0;
		} else if (x == 1) {
			return 32 + a;
		} else if (x == 2) {
			return 64 + a;
		} else if (x == 3) {
			return 96 + a;
		} else if (x == 4) {
			return 128 + a;
		} else if (x == 5) {
			return 160 + a;
		} else if (x == 6) {
			return 192 + a;
		} else if (x == 7) {
			return 224 + a;
		} else if (x == 8) {
			return 256 + a;
		} else if (x == 9) {
			return 288 + a;
		} else if (x == 10) {
			return 320 + a;
		} else if (x == 11) {
			return 352 + a;
		} else if (x == 12) {
			return 384 + a;
		} else if (x == 13) {
			return 416 + a;
		} else if (x == 14) {
			return 448 + a;
		} else if (x == 15) {
			return 480 + a;
		} else if (x == 16) {
			return 512 + a;
		} else if (x == 17) {
			return 544 + a;
		} else if (x == 18) {
			return 576 + a;
		} else if (x == 19) {
			return 608 + a;
		} else if (x == 20) {
			return 640 + a;
		} else if (x == 21) {
			return 672 + a;
		} else if (x == 22) {
			return 704 + a;
		} else if (x == 23) {
			return 736 + a;
		}
		return 0;
	}

	private int getMatrizXY(float x) {
		if (x > 0 && x <= 32) {
			return 0;
		} else if (x > 32 && x <= 64) {
			return 1;
		} else if (x > 64 && x <= 96) {
			return 2;
		} else if (x > 96 && x <= 128) {
			return 3;
		} else if (x > 128 && x <= 160) {
			return 4;
		} else if (x > 160 && x <= 192) {
			return 5;
		} else if (x > 192 && x <= 224) {
			return 6;
		} else if (x > 224 && x <= 256) {
			return 7;
		} else if (x > 256 && x <= 288) {
			return 8;
		} else if (x > 288 && x <= 320) {
			return 9;
		} else if (x > 320 && x <= 352) {
			return 10;
		} else if (x > 352 && x <= 384) {
			return 11;
		} else if (x > 384 && x <= 416) {
			return 12;
		} else if (x > 416 && x <= 448) {
			return 13;
		} else if (x > 448 && x <= 480) {
			return 14;
		} else if (x > 480 && x <= 512) {
			return 15;
		} else if (x > 512 && x <= 544) {
			return 16;
		} else if (x > 544 && x <= 576) {
			return 17;
		} else if (x > 576 && x <= 608) {
			return 18;
		} else if (x > 608 && x <= 640) {
			return 19;
		} else if (x > 640 && x <= 672) {
			return 20;
		} else if (x > 672 && x <= 704) {
			return 21;
		} else if (x > 704 && x <= 736) {
			return 22;
		} else if (x > 736 && x <= 768) {
			return 23;
		}
		return 0;
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
