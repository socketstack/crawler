//package com.zxsoft.crawler.protocols.http.httpclient;
//
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.thinkingcloud.framework.util.CollectionUtils;
//import org.thinkingcloud.framework.util.StringUtils;
//
//import com.zxsoft.crawler.protocol.ProtocolOutput;
//import com.zxsoft.crawler.protocols.http.HttpFetcher;
//import com.zxsoft.crawler.util.URLNormalizer;
//import com.zxsoft.crawler.util.Utils;
//import com.zxsoft.crawler.util.page.NextPageNotFoundException;
//import com.zxsoft.crawler.util.page.PageBarNotFoundException;
//import com.zxsoft.crawler.util.page.PageHelper;
//import com.zxsoft.crawler.util.page.PrevPageNotFoundException;
//
///**
// * 获取分页信息，包括上一页、下一页、末页
// * 
// * @return url
// */
//public final class HttpClientPageHelper extends PageHelper {
//
//	private HttpFetcher httpFetcher;
//	
//	private ProtocolOutput load(Element ele) {
//		String url = ele.absUrl("href");
////		currentText = ele.text();
//			if (StringUtils.isEmpty(url))
//				return null;
//			url = URLNormalizer.normalize(url);
//		return httpFetcher.fetch(url, false);
//	}
//
//	public ProtocolOutput loadNextPage(int pageNum, Document currentDoc) throws PageBarNotFoundException, NextPageNotFoundException  {
////		currentUrl = currentDoc.location();
//		Elements elements = currentDoc.select("a:matchesOwn(下一页|下页|下一页>)");
//		if (!CollectionUtils.isEmpty(elements)) {
//			return load(elements.first());
//		} else {
//			/*
//			 * Find the position of current page url from page bar, get next
//			 * achor as the next page url. However, there is a problem. It's not
//			 * very accurate, some url cannot find from page bar, because it
//			 * changed when load it.
//			 */
//			Element pagebar = getPageBar(currentDoc);
//			if (pagebar != null) {
//				Elements achors = pagebar.getElementsByTag("a");
//				if (pagebar != null || !CollectionUtils.isEmpty(achors)) {
//					for (int i = 0; i < achors.size(); i++) {
//						if (Utils.isNum(achors.get(i).text())
//								&& Integer.valueOf(achors.get(i).text().trim()) == pageNum + 1) {
//							return load(achors.get(i));
//						}
//					}
//				}
//			}
//		}
//		throw new NextPageNotFoundException();
//	}
//
//	/**
//	 * 加载上一页
//	 * @throws PageBarNotFoundException 
//	 * @throws PrevPageNotFoundException 
//	 */
//	public ProtocolOutput loadPrevPage(int pageNum, Document currentDoc) throws PageBarNotFoundException, PrevPageNotFoundException  {
////		currentUrl = currentDoc.location();
//		Elements elements = currentDoc.select("a:matchesOwn(上一页|上页|<上一页)");
//		if (!CollectionUtils.isEmpty(elements)) {
//			return load(elements.first());
//		} else if (pageNum > 1) {
//			Element pagebar = getPageBar(currentDoc);
//			if (pagebar != null) {
//				Elements achors = pagebar.getElementsByTag("a");
//				if (pagebar != null || !CollectionUtils.isEmpty(achors)) {
//					for (int i = 0; i < achors.size(); i++) {
//						if (Utils.isNum(achors.get(i).text())
//								&& Integer.valueOf(achors.get(i).text().trim()) == pageNum - 1) {
//							return load(achors.get(i));
//						}
//					}
//				}
//			}
//		}
//		throw new PrevPageNotFoundException();
//	}
//
//	public ProtocolOutput loadLastPage(Document currentDoc) throws PageBarNotFoundException {
////		currentUrl = currentDoc.location();
//		Elements lastEles = currentDoc.select("a:matchesOwn(尾页|末页|最后一页)");
//		if (!CollectionUtils.isEmpty(lastEles)) {
//			return load(lastEles.first());
//		}
//
//		// 1. get all links from page bar
//		Element pagebar = getPageBar(currentDoc);
//		Elements links = pagebar.getElementsByTag("a");
//		if (CollectionUtils.isEmpty(links)) {
//			return null;
//		}
//
//		// 2. get max num or contains something in all links, that is last page
//		int i = 1;
//		Element el = null;
//		for (Element ele : links) {
//			String v = ele.text();
//			if ("18255266882".equals(v)) {
//				System.out.println(ele);
//			}
//			if (Utils.isNum(v) && Integer.valueOf(v) > i) { // get max num
//				i = Integer.valueOf(v);
//				el = ele;
//			}
//		}
//
//		return load(el);
//	}
//
//	
//}
