package com.test;

import com.test.web.i18n.I18NService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
    private I18NService i18NService;

	@Test
    public void testMessageLocaleService() throws Exception {
	    char[] expectedResult = "Bootstrap starter template".toCharArray();
	    String messageId = "index.main.callout";
	    char[] actual = i18NService.getMessage(messageId).toCharArray();
        Assert.assertArrayEquals("The actual and expected result don't match", expectedResult, actual);
    }

}
