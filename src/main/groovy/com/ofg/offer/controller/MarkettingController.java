package com.ofg.offer.controller;


import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ofg.offer.dto.LoanDecision;
import com.ofg.offer.dto.MarketingOffer;
import com.ofg.offer.dto.Person;
import com.ofg.offer.repository.MarketingOfferRepository;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/marketing")
@Api(value = "MarkettingOfferGenerator", description = "Generates offers")
public class MarkettingController {
	
	@Autowired
	MarketingOfferRepository repo;
	
	@RequestMapping(
            value = "{loanApplicationId}",
            method = RequestMethod.PUT,
            consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Async collecting and propagating of tweets for a given pairId",
            notes = "This will asynchronously call tweet collecting, place extracting and their propagation to Collerators")
	public void generateMarketingOffer(@PathVariable long loanApplicationId, @RequestBody LoanDecision loanDecision){
		MarketingOffer marketingOfer = new MarketingOffer();
		marketingOfer.setMarketingOffer("OKI");
		repo.putMarketingOffer(loanDecision.getPerson(), marketingOfer);
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
		String firstName = firstLastName.split("_")[0];
		String lastName = firstLastName.split("_")[1];
		Person p = new Person();
		p.setFirstName(firstName);
		p.setLastName(lastName);
		return repo.getMarketingOffer(p);
	}
}
