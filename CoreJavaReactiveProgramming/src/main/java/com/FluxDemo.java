package com;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;

public class FluxDemo {

	public static void main(String[] args) {
	//1st Example in Flux produce one data type of integer 
//	Flux<Integer> ff = Flux.just(1);
//	ff.subscribe(ele->System.out.println(ele));

	//2nd Example Flux produce many data of type integer
//	Flux<Integer> ff = Flux.just(1,2,3,4,5,6,7,8,9,10);
//	ff.subscribe(ele->System.out.println(ele));
		
	//3rd example 
//		Flux<Integer> ff = Flux.just(1,2,3,4,5,6,7,8,9,10);		// server 
//		
//		ff.subscribe(ele->System.out.println(ele),			// rest client 
//		error->System.out.println(error),
//		()->System.out.println("done"));
		
		//4th Example 
//		List<String> listOfNames = new ArrayList<>();
//		listOfNames.add("Ravi");
//		listOfNames.add("Ramesh");
//		listOfNames.add("Lokesh");
//		listOfNames.add("Rajesh");
		
		// it hols list of names 
//		List<String> listOfNames = Arrays.asList("Ravi","Ramesh","Lokesh","Mahesh");
//		
//		Flux<String> fluxNames = Flux.fromIterable(listOfNames);
//		
//		fluxNames.subscribe(ele->System.out.println(ele),
//				error->System.out.println(error),
//				()->System.out.println("done"));
		
		List<Product> listOfProduct = Arrays.asList(
				new Product(1, "TV", 45000),
				new Product(2, "Computer", 65000),
				new Product(3, "Laptop", 85000));
		
		// Spring boot with Producer as Observable with RxJsFeatures 
		Flux<Product> fluxOfProduct = Flux.fromIterable(listOfProduct);
		
		// Spring boot with Cosumer as subscriber with Rxjs features 
		fluxOfProduct.subscribe(
				p->System.out.println(p),
				error->System.out.println(error),
				()->System.out.println("done"));
		
	}

}
