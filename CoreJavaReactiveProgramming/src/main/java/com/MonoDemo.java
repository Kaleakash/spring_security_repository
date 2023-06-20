package com;

import java.util.function.Consumer;

import reactor.core.publisher.Mono;
class MyConsumer implements Consumer<String>{
	@Override
	public void accept(String t) {
	System.out.println("Result "+t);
	}
}
public class MonoDemo {
	public static void main(String[] args) {
	// this.httpClient.get("url"). this method return type is Observable. 	
	/*
	 * 	this.httpClient.get("url").subscribe({
	 * 	next(),		to load the data 
	 *  error(),	to handle any error generate at begining or middle or last
	 *  complete()	after loaded successfully data this function get call. 
	 * })
	 * 
	 * 	
	 */
	//1st simple Mono Example 
		// we create own Observable which publish string data.
//	Mono<String> mm = Mono.just("Hello Welcome to RxJS Using Mono");
//	// to get the data from observable 
//	//mm.subscribe(dd->System.out.println(dd));
//	Consumer<String> cc = new MyConsumer();
//	mm.subscribe(cc);
//	
//	Mono<Integer> mm1 = Mono.just(100);
//	mm1.subscribe(ele->System.out.println(ele));
		
		//2nd simple mono example with 3 parameter of subscribe 
		
//		Mono<Integer> mm = Mono.just(100);
//		//mm.su
//		mm.subscribe(
//				ele->System.out.println(ele), 
//				error->System.out.println(error), 
//				()->System.out.println("Work completed"));
		
		//3rd example
		Mono<Integer> mm = Mono.just(100).error(new Exception("Exeption generated"));
		//mm.su
		mm.subscribe(
				ele->System.out.println(ele), 
				error->System.out.println(error), 
				()->System.out.println("Work completed"));
	}

}
