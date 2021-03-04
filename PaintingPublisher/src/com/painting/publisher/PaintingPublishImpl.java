package com.painting.publisher;

import java.util.Scanner;

import com.artist.publisher.ArtistPublish;
import com.customer.consumer.CustomerConsume;
import com.delivery.publisher.DeliveryPublish;

public class PaintingPublishImpl implements PaintingPublish{
	
	ArtistPublish artistPublish;
	DeliveryPublish deliveryPublish; 
	CustomerConsume customerConsume;
	 
	
	public PaintingPublishImpl(ArtistPublish artistPublish , DeliveryPublish deliveryPublish, CustomerConsume customerConsume) {
		
		this.artistPublish = artistPublish;
		this.deliveryPublish = deliveryPublish; 
		this.customerConsume = customerConsume;
		
		
	}

	@Override
	public void init() {
		Scanner in = new Scanner(System.in);
		System.out.println("***Painting Management Services***");
		welcomePrompt();
		int input = in.nextInt();
		while (input != 4) {

			switch (input) {
			case 1:
				artist();
				break;
			case 2:
				delivery();
				break;
			case 3:
				customer();
				break;
			default:
				System.out.println("Invalid input!!!");
				break;
			}
			welcomePrompt();
			input = in.nextInt();
		}

	}

	private void welcomePrompt() {
		System.out.println("");
		System.out.println("What do you need to do?");
		System.out.println("  1 - Artist Management");
		System.out.println("  2 - Delivery Management");
		System.out.println("  3 - Customer Management");
		System.out.println("  4 - Exit");
		System.out.println("");
		System.out.print("Please enter a number : ");
	}
		
	
/*
	@Override
	public void add() {
		//artistPublish.add();
		
	}

	@Override
	public void view() {
		//artistPublish.view();
		
	}

	@Override
	public void remove() {
		//artistPublish.remove();
		
	}
*/
	@Override
	public void artist() {
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("Artist Management");
		System.out.println("How would you like to proceed?");
		System.out.println("  1 - Add new artist");
		System.out.println("  2 - Display artist");
		System.out.println("  3 - Back");
		System.out.println("");

		System.out.print("Please enter a number : ");
		int input = in.nextInt();

		while (input != 3) {

			switch (input) {
			case 1:
				artistPublish.add();
				break;
			case 2:
				artistPublish.get();
				break;
			default:
				System.out.println("Invalid input!!!");
				break;
			}
			System.out.print("Please enter a number : ");
			input = in.nextInt();
		}
	}

	
	@Override
	public void delivery() {
		
	Scanner in = new Scanner(System.in);
	System.out.println("");
	System.out.println("Delivery Management");
	System.out.println("How would you like to proceed?");
	System.out.println("  1 - Add new delivery");
	System.out.println("  2 - View delivery details");
	System.out.println("  3 - Back");
	System.out.println("");

	System.out.print("Please enter a number : ");
	int input = in.nextInt();

	while (input != 3) {

		switch (input) {
		case 1:
			deliveryPublish.add();
			break;
		case 2:
			deliveryPublish.get();
			break;
		default:
			System.out.println("Invalid input!!!");
			break;
		}
		System.out.print("Please enter a number : ");
		input = in.nextInt();
	
		}
	}

	@Override
	public void customer() {
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("Customer Management");
		System.out.println("How would you like to proceed?");
		System.out.println("  1 - Add new customer");
		System.out.println("  2 - View customer details");
		System.out.println("  3 - Back");
		System.out.println("");

		System.out.print("Please enter a number : ");
		int input = in.nextInt();

		while (input != 3) {

			switch (input) {
			case 1:
				customerConsume.add();
				break;
			case 2:
				customerConsume.get();
				break;
			default:
				System.out.println("Invalid input!!!");
				break;
			}
			System.out.print("Please enter a number : ");
			input = in.nextInt();
		}
		
	}

}
