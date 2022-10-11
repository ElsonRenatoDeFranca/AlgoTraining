package com.challenge.parkSystem.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class KeyWordSearcherServiceImplTest {

    @InjectMocks
    private KeyWordSearcherService keyWordSearcherService = new KeyWordSearcherServiceImpl();

    @Test
    public void shouldFindTheMostCommonWordThatIsNotBannedWhenThereIsNoBannedWord(){
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String expectedOutput = "hit";
        String actualOutput = keyWordSearcherService.findMostCommonWord(paragraph);
        Assertions.assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}