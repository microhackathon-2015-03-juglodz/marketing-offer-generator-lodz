package com.ofg.offer.controller;


import java.util.concurrent.Callable;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ofg.offer.dto.LoanDecision;
import com.ofg.offer.dto.MarketingOffer;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/marketting")
@Api(value = "MarkettingOfferGenerator", description = "Generates offers")
public class MarkettingController {
	
	@RequestMapping(
            value = "{loanApplicationId}",
            method = RequestMethod.PUT,
            consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Async collecting and propagating of tweets for a given pairId",
            notes = "This will asynchronously call tweet collecting, place extracting and their propagation to Collerators")
	public void generateMarketingOffer(@PathVariable long loanApplicationId, LoanDecision loanDecision){
		System.out.println("Works!!!!!!!!!!! "+loanApplicationId);
	}
	
	@RequestMapping(
            value = "{firstLastName}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
			)
	@ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Async collecting and propagating of tweets for a given pairId",
            notes = "This will asynchronously call tweet collecting, place extracting and their propagation to Collerators")
	public MarketingOffer getMarketingOffer(@PathVariable String firstLastName){
		System.out.println("Works!!!!!!!!!!! "+firstLastName);
		MarketingOffer offer = new MarketingOffer();
		offer.setMarketingOffer("Offer");
		return offer;
	}
}
