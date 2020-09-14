package com.legenda.lee.studyurule;

import com.alibaba.fastjson.JSON;
import com.bstek.urule.Utils;
import com.bstek.urule.console.repository.KnowledgePackageRepositoryService;
import com.bstek.urule.console.repository.RepositoryService;
import com.bstek.urule.console.repository.model.RepositoryFile;
import com.bstek.urule.console.repository.model.VersionFile;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.service.KnowledgeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@SpringBootTest
class StudyUruleApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        System.out.println("Hello World");
    }

    /**
     * 根据指定格式的知识包信息，获取当前知识包的所有已发布的版本信息
     * @param packageInfo 知识包信息，格式为：项目名/知识包ID，如:testProject/testPackage
     * @return 返回所有已发布的知识包版本集合信息
     */
    @Test
    void test2() throws IOException {
        KnowledgePackageRepositoryService knowledgeService = (KnowledgePackageRepositoryService) Utils.getApplicationContext().getBean(KnowledgePackageRepositoryService.BEAN_ID);
        List<VersionFile> knowledgePackage = knowledgeService.getKnowledgePackges("药品数据匹配事件/pkg1");
        System.out.println(knowledgePackage);
    }

    /**
     * 将指定项目以xml形式导出
     * @param projectPath 要导出项目
     * @param outputStream 导入后的项目要输出的目的地
     * @throws Exception 抛出异常
     */
    @Test
    void test3() throws Exception {
        RepositoryService knowledgeService = (RepositoryService) Utils.getApplicationContext().getBean(RepositoryService.BEAN_ID);
        // 第1步、使用File类找到一个文件
        File f= new File("/Users/legendalee/Desktop/药品数据匹配事件.xml");
        // 第2步、通过子类实例化父类对象
        OutputStream outputStream = new FileOutputStream(f);
        knowledgeService.exportXml("/药品数据匹配事件", outputStream);
        System.out.println("abc");
    }

    @Test
    void test4() throws IOException {
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("药品数据匹配事件/pkg1");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);
        List<KnowledgePackage> knowledgePackageList = session.getKnowledgePackageList();
        System.out.println("abc");
    }


    @Test
    void test5() throws Exception {
        RepositoryService knowledgeService = (RepositoryService) Utils.getApplicationContext().getBean(RepositoryService.BEAN_ID);

        List<RepositoryFile> repositoryFiles = knowledgeService.loadProjects("www.91jkys.com");
        System.out.println("abc");
    }

    @Test
    void test6_1() throws IOException {
        KnowledgePackageRepositoryService knowledgeService = (KnowledgePackageRepositoryService) Utils.getApplicationContext().getBean(KnowledgePackageRepositoryService.BEAN_ID);
        /**
         * @param packageInfo 知识包信息，格式为：项目名/知识包ID，如:testProject/testPackage
         * @return 返回已发布的当前处于激活状态下的知识包的版本信息
         */
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledgePackge("药品数据匹配事件/pkg1", "1.0");
        // {"actived":true,"comment":"修改了库文件","createDate":1599479868960,"createUser":"admin","name":"1.0","path":"/___knowledge_package_data__药品数据匹配事件/pkg1/1.0","state":true,"timestamp":1599479868813}

        System.out.println(JSON.toJSONString(knowledgePackage));
    }

    @Test
    void test6() throws IOException {
        KnowledgePackageRepositoryService knowledgeService = (KnowledgePackageRepositoryService) Utils.getApplicationContext().getBean(KnowledgePackageRepositoryService.BEAN_ID);
        /**
         * @param packageInfo 知识包信息，格式为：项目名/知识包ID，如:testProject/testPackage
         * @return 返回已发布的当前处于激活状态下的知识包的版本信息
         */
        VersionFile versionFile = knowledgeService.getActivedKnowledgePackge("药品数据匹配事件/pkg1");
        // {"actived":true,"comment":"修改了库文件","createDate":1599479868960,"createUser":"admin","name":"1.0","path":"/___knowledge_package_data__药品数据匹配事件/pkg1/1.0","state":true,"timestamp":1599479868813}

        System.out.println(JSON.toJSONString(versionFile));
    }

    @Test
    void test7() throws IOException {
        KnowledgePackageRepositoryService knowledgeService = (KnowledgePackageRepositoryService) Utils.getApplicationContext().getBean(KnowledgePackageRepositoryService.BEAN_ID);
        Map<String,Object> knowledgePackage = knowledgeService.loadKnowledgePackageFiles("药品数据匹配事件/pkg1", "1.0");

        System.out.println(JSON.toJSONString(knowledgePackage));
    }


}
