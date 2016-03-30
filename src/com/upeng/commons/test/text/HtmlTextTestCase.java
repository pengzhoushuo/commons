package com.upeng.commons.test.text;

import com.upeng.commons.text.HtmlText;

import junit.framework.TestCase;

public class HtmlTextTestCase extends TestCase {

	public void testRemoveTags() {
		String html = "<html><head></head><body><br/>&nbsp;&nbsp;haha<body></html>";
		TestCase.assertEquals("haha", HtmlText.removeTags(html));
	}

}
