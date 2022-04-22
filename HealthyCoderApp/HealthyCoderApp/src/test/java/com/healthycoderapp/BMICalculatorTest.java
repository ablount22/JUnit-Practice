package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BMICalculatorTest {

	@Test
	void should_ReturnTrue_When_DietRecommended() {
		
		//given
		double weight = 89.0;
		double height= 1.72;		
		
		//when
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		
		//then
		assertTrue(recommended);
		
	
	}

	@Test
	void should_ReturnFalse_When_DietRecommended() {
		
		//given
		double weight = 50.0;
		double height= 1.92;
		
		//when
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		
		//then
		assertFalse(recommended);
		
	
	}
	
	@Test
	void should_ThrowArithmeticException_When_HeightZero() {
		
		//given
		double weight = 50.0;
		double height= 0.00;
		
		//when
		Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
		
		//then
		assertThrows(ArithmeticExeception.class, executable);
		
	
	}
	
	@Test
	void shoild_ReturnCoderWithWorstBMI_When_CoderListNotEmpty () {
		
		//given
		List<Coder> coders = new ArrayList<>();
		coders.add(new Coder(1.80, 60.0));
		coders.add(new Coder(1.82, 98.0));
		coders.add(new Coder(1.82, 64.7));
		
		//when
		Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
		
		//then
		assertAll (
		() -> assertEquals(1.82, coderWorstBMI.getHeight()),
		() -> assertEquals(98.0, coderWorstBMI.getWeight())
		);
	}
}
