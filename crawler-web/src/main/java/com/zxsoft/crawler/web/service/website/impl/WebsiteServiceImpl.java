package com.zxsoft.crawler.web.service.website.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thinkingcloud.framework.web.utils.Page;

import com.zxisl.commons.utils.CollectionUtils;
import com.zxsoft.crawler.entity.Auth;
import com.zxsoft.crawler.entity.ConfDetail;
import com.zxsoft.crawler.entity.ConfList;
import com.zxsoft.crawler.entity.Section;
import com.zxsoft.crawler.entity.Website;
import com.zxsoft.crawler.web.dao.website.WebsiteDao;
import com.zxsoft.crawler.web.service.website.SectionService;
import com.zxsoft.crawler.web.service.website.WebsiteService;

@Service
public class WebsiteServiceImpl implements WebsiteService {

        @Autowired
        private WebsiteDao websiteDao;

        @Override
        public Page<Website> getWebsite(Website website, int pageNo, int pageSize) {

                return websiteDao.getWebsites(website, pageNo, pageSize);
        }

        @Override
        public void addWebsite(Website website) {
                websiteDao.addWebsite(website);
        }

        @Override
        public void save(Website website) {
                websiteDao.addWebsite(website);
        }

        @Override
        public Website getWebsite(String id) {
                
                
                
                
                
                return websiteDao.getWebsite(id);
        }

        @Autowired
        private SectionService sectionService;
        
        @Override
        @Transactional
        public void deleteWebsite(String id) {
                Website website = websiteDao.getWebsite(id);
                Set<Section> sections = website.getSections();
                if (!CollectionUtils.isEmpty(sections)) {
                        for (Section section : sections) {
                                sectionService.delete(section);
                        }
                        
                }
                websiteDao.deleteWebsite(website);
        }

        @Override
        public List<Auth> getAuths(String id) {
                return websiteDao.getAuths(id);
        }

        @Override
        public void saveAuth(Auth auth) {
                websiteDao.addAuth(auth);
        }

        @Override
        public Auth getAuth(String id) {
                return websiteDao.getAuth(id);
        }

        @Override
        public void deleteAuth(String id) {
                websiteDao.deleteAuth(id);
        }

}
