package com.dibole.codegenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.*;

/**
 * @author Tao
 * @version 1.0.0
 * @className CodeGenerator.java
 * @description 代码生成器
 * @createTime 2020年12月07日 10:42:00
 */
public class CodeGenerator {

    private static String zrrdkMapperXmlProjectPath ="/zrrdk-dao/src/main/resources/mapper/zrrdk/";
    private static String zrrdkMapperJavaProjectPath ="/zrrdk-dao/src/main/java/com/dibole/dao/mysql/zrrdk/";
    private static String zrrdkRespositoryXmlProjectPath ="/zrrdk-dao/src/main/resources/mapper/zrrdk/respository/";
    private static String zrrdkRespositoryJavaProjectPath ="/zrrdk-dao/src/main/java/com/dibole/dao/mysql/zrrdk/respository/";
    private static String zrrdkEntityJavaProjectPath ="/zrrdk-entity/src/main/java/com/dibole/entity/zrrdk/";
    private static String zrrdkResultJavaProjectPath ="/zrrdk-entity/src/main/java/com/dibole/entity/zrrdk/result/";
    private static String zrrdkServiceProjectPath ="/zrrdk-service/src/main/java/com/dibole/service/zrrdk/";
    private static String zrrdkServiceImplProjectPath ="/zrrdk-service/src/main/java/com/dibole/service/zrrdk/impl/";
    private static String h5ControllerProjectPath ="/zrrdk-h5/src/main/java/com/dibole/controller/";
    private static String wxappControllerProjectPath ="/zrrdk-wxapp/src/main/java/com/dibole/wxapp/controller/";
    private static String adminControllerProjectPath ="/zrrdk-admin/src/main/java/com/dibole/controller/";

    

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取项目路径
        String projectPath = System.getProperty("user.dir");
        // 生成文件的输出目录
        gc.setOutputDir(projectPath);
        // 开发人员
        gc.setAuthor("haitao");
        // 是否打开输出目录
        gc.setOpen(false);
        // 是否覆盖已有文件
        gc.setFileOverride(true);
        // 去除 Service 的 I 前缀
        gc.setServiceName("%sService");
        // 指定生成的主键的ID类型
        gc.setIdType(IdType.ASSIGN_ID);
        // 时间类型对应策略
        gc.setDateType(DateType.TIME_PACK);
        // 开启 swagger2 模式
        gc.setSwagger2(true);
        // 开启xml文件ResultMap
        gc.setBaseResultMap(true);
        // 开启xml文件列名
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // 数据库类型
        dsc.setDbType(DbType.MYSQL);
        // 驱动连接的URL
        dsc.setUrl("jdbc:mysql://172.81.206.191:3307/lyb-test?useSSL=true&useUnicode=true&tinyInt1isBit=false&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        // 驱动名称
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        // 数据库连接用户名
        dsc.setUsername("root");
        // 数据库连接密码
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 父包模块名
        //pc.setModuleName(scanner("mybatis_plus"));
        // 父包名
        pc.setParent("com.dibole");
        // Entity包名
        pc.setEntity("entity.zrrdk");
        // Mapper包名
        pc.setMapper("dao.mysql.zrrdk");
        // Service包名
        pc.setService("service.zrrdk");
        // ServiceImpl包名
        pc.setServiceImpl("service.zrrdk.impl");
        // Controller包名
        pc.setController("wxapp.controller");
        //xml
        //pc.setXml("mapper");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置需要映射的表名
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // 数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // entity公共父类
        strategy.setSuperEntityClass("com.dibole.codegenerator.entity.CommonEntity");
        // controller公共父类
        strategy.setSuperControllerClass("com.dibole.commons.api.CommonController");
        // 【实体】是否为lombok模型
        strategy.setEntityLombokModel(true);
        // 生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        // 自动填充配置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_create", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        // 乐观锁属性名称
        strategy.setVersionFieldName("version");
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("respositoryJavaPackage", "com.dibole.dao.mysql.zrrdk.respository");
                map.put("resultPackage", "com.dibole.entity.zrrdk.result");
                this.setMap(map);
            }
        };
        //是否覆盖文件
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建,这里调用默认的方法
                checkDir(filePath);
                //对于已存在的文件，只需重复生成 entity 和 mapper.xml
                File file = new File(filePath);
                boolean exist = file.exists();
                if (exist) {
                    if (filePath.endsWith("Mapper.xml") || fileType == FileType.ENTITY) {
                        return true;
                    } else {
                        return false;
                    }
                }
                //不存在的文件都需要创建
                return true;
            }
        });
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + zrrdkMapperXmlProjectPath
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + zrrdkMapperJavaProjectPath
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/respository.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + zrrdkRespositoryXmlProjectPath
                        + tableInfo.getEntityName() + "Respository"+StringPool.DOT_XML;
            }
        });
        focList.add(new FileOutConfig("/templates/respository.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + zrrdkRespositoryJavaProjectPath
                        + tableInfo.getEntityName() + "Respository"+StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + zrrdkEntityJavaProjectPath
                        + tableInfo.getEntityName()+StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/result.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + zrrdkResultJavaProjectPath
                        + tableInfo.getEntityName() + "Result"+StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + zrrdkServiceProjectPath
                        + tableInfo.getEntityName() + "Service"+StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + zrrdkServiceImplProjectPath
                        + tableInfo.getEntityName() + "ServiceImpl"+StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/controllerSupper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + wxappControllerProjectPath
                        + tableInfo.getEntityName() + "Controller"+StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 执行代码生成器
        mpg.execute();
    }
}
