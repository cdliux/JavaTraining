package JavaBasic;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import constant.TypeEnumWithValue;
import pojo.Seller;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import pojo.jsonProcess.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;;

/**
 * @author ll0a
 * @version V1.0
 * @className: JavaJsonProcess
 * @date 5/20/2020 11:10 AM
 * @description:
 */
public class JavaJsonProcess {
    private ObjectMapper objectMapper = new ObjectMapper();
    private ObjectMapper objectMapperWithDefaultConfig = new ObjectMapper();

    public void process() throws JsonProcessingException, ParseException {
        System.out.print("------------------------------");
        System.out.println("\nJava Json 处理\n");

        configObjectMapper();
        useObjectMapper();
        objectMapperConfig();
        useJsonAnnotation();
        useJsonAnyGetter();
        useJsonGetter();
        useJsonPropertyOrder();
        useJsonRawValue();
        useJsonValue();
        useJsonRootName();
        userJsonSerialize();
        useJsonCreator();
        useJacksonInject();
        useJsonAnySetter();
        useJsonSetter();
        useJsonDeserialize();
        useJsonAlias();
        processList();
        processMap();
    }

    private void useObjectMapper() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\nObjectMapper 的使用方式");

        Seller seller = new Seller("A001", "Lewis", "address1");
        String sellerStr = objectMapperWithDefaultConfig.writeValueAsString(seller);
        System.out.println("objectMapper.writeValueAsString -> " + sellerStr);

        String sellerJson = "{\"sellerId\":\"A001\",\"sellerName\":\"Lewis\",\"sellerAddress\":{\"countryCode\":null,\"stateCode\":null,\"city\":null,\"zipCode\":null,\"address1\":\"address1\",\"address2\":null}}";
        //注意 Json 反序列化时需要一个无参构造器，在添加了有参构造器的情况下，需要手动添加无参构造器
        objectMapperWithDefaultConfig.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Seller deserializedSeller = objectMapperWithDefaultConfig.readValue(sellerJson, Seller.class);

    }

    private void objectMapperConfig() throws JsonProcessingException {
        Seller seller = new Seller("A001", null, "address1");
        String sellerStr = objectMapper.writeValueAsString(seller);
        System.out.println("objectMapperWithConfig -> " + sellerStr);

        String sellerJson = "{\"sellerId\":\"A001\",\"sellerName\":\"Lewis\",\"sellerAddress\":{\"countryCode\":null,\"stateCode\":null,\"city\":null,\"zipCode\":null,\"address3\":\"address1\",\"address2\":null}}";
        Seller deserializedSeller = objectMapper.readValue(sellerJson, Seller.class);
    }

    private void configObjectMapper() {
        System.out.print("------------------------------");
        System.out.println("\nObjectMapper 配置");
        System.out.println("\n注意：使用过程中不要更改ObjectMapper设置。映射器使用后，由于序列化程序和反序列化程序的缓存，并非所有设置都生效。\n" +
                "配置一次实例，第一次使用后不要更改设置。这样做是为了线程安全和性能。");

        //反序列化相关配置
        //忽略在 Json 中存在但是 Java 实体中不存在的属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //序列化相关配置
        //设置序列化的日期格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //忽略为 Null 的属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //忽略为默认值的属性
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
    }

    private void useJsonAnnotation() {
        System.out.print("------------------------------");
        System.out.println("\nJackson 注解使用");
    }

    private void useJsonAnyGetter() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\nJsonAnyGetter 注解使用");
        System.out.println("JsonAnyGetter 将 Map 中的每个 key 都序列化为一个标准属性");
        System.out.println("JsonAnyGetter 接受一个 enabled 参数，为 false 时此注解不生效");
        ExtendableBean myBean = new ExtendableBean("myBean");
        myBean.add("prop1", "value1");
        myBean.add("prop2", "value2");
        String result = objectMapper.writeValueAsString(myBean);
        System.out.println("useJsonAnyGetter -> " + result);
    }

    private void useJsonGetter() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JsonGetter 注解使用");
        System.out.println("@JsonGetter 标记一个方法为序列化时的 Getter 方法");
        ExtendableBean myBean = new ExtendableBean("myBean");
        String result = objectMapper.writeValueAsString(myBean);
        System.out.println("useJsonAnyGetter -> " + result);
    }

    private void useJsonPropertyOrder() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JsonPropertyOrder 注解使用");
        System.out.println("@JsonPropertyOrder 用于指定序列化时属性的顺序");
        ExtendableBean myBean = new ExtendableBean("myBean");
        myBean.setId(Integer.valueOf(1));
        myBean.add("prop1", "value1");
        myBean.add("prop2", "value2");
        String result = objectMapper.writeValueAsString(myBean);
        System.out.println("useJsonPropertyOrder -> " + result);
    }

    private void useJsonRawValue() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JsonRawValue 注解使用");
        System.out.println("@JsonRawValue 用于将属性中的 Json 值也进行序列化，而不是原样输出");
        RawBean bean = new RawBean("My bean", "{\"attr\":false}");
        String result = objectMapper.writeValueAsString(bean);
        System.out.println("useJsonRawValue -> " + result);
        // System.out.println("notUseJsonRawValue -> " + result);
    }

    private void useJsonValue() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JsonValue 注解使用");
        System.out.println("@JsonValue 表明Jackson在序列化该类实例时，只序列化字段的值或方法返回值。 一个类中最多使用一个@JsonValue注解");
        String enumAsString = objectMapper.writeValueAsString(TypeEnumWithValue.TYPE1);
        System.out.println("useJsonValue -> " + enumAsString);
    }

    private void useJsonRootName() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JsonRootName 注解使用");
        System.out.println("@JsonRootName 用于将序列化的结果再包装一层");
        UserWithRoot user = new UserWithRoot(Integer.valueOf(1), "Lewis");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String resultWithRoot = mapper.writeValueAsString(user);
        System.out.println("resultWithRoot -> " + resultWithRoot);
        // String resultWithoutRoot =  objectMapper.writeValueAsString(user);
        // System.out.println("resultWithoutRoot -> " + resultWithoutRoot);
    }

    public void userJsonSerialize() throws ParseException, JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JsonSerialize 注解使用");
        System.out.println("@JsonSerialize 作用在类，字段，getter方法，表示自定义序列化。字段和getter方法上面的优先级比在类上的高。");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String toParse = "20-12-2014 02:30:00";
        Date date = formatter.parse(toParse);
        EventWithSerializer event = new EventWithSerializer("party", date);
        String result = objectMapper.writeValueAsString(event);
        System.out.println("userJsonSerialize -> " + result);
    }

    public void useJsonCreator() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JsonCreator 注解使用");
        System.out.println("@JsonCreator 用于指定反序列化时使用的构造函数。当进行反序列化时，带有 @JsonCreator 注解的构造函数被会调用，如果没有@JsonCreator注解，则默认调用无参构造函数。");
        String json = "{\"id\":1,\"firstName\":\"Lewis\"}";
        BeanWithCreator myBean = objectMapper.readValue(json, BeanWithCreator.class);
    }

    public void useJacksonInject() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JacksonInject 注解使用");
        System.out.println("\n@JacksonInject 用于指定反序列化时某个字段取注入的值，而不是从 Json 中读取。");
        InjectableValues inject = new InjectableValues.Std().addValue(Integer.class, Integer.valueOf(1));
        String json = "{\"name\":\"Lewis\"}";
        BeanWithInject bean = objectMapper.reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json);
    }

    private void useJsonAnySetter() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JsonAnySetter 注解使用");
        System.out.println("\n@JsonAnySetter 用于在反序列化时，将 Json 中的属性加入到 Map 中");
        String json = "{\"sellerName\":\"Lewis\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";
        ExtendableBean bean = new ObjectMapper()
                .readerFor(ExtendableBean.class)
                .readValue(json);
    }

    private void useJsonSetter() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JsonSetter 注解使用");
        System.out.println("\n@JsonSetter 标记一个方法为序列化时的 Setter 方法");
        String json = "{\"id\":1,\"sellerName\":\"My bean\"}";
        MyBean bean = objectMapper.readValue(json, MyBean.class);
    }

    private void useJsonDeserialize() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JsonDeserialize 注解使用");
        System.out.println("\n@JsonDeserialize 使用自定义的反序列化器来进行反序列化，实现StdDeserializer或是其父类JsonSerializer");
        String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";
        SimpleDateFormat df
                = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        EventWithSerializer event = new ObjectMapper()
                .readerFor(EventWithSerializer.class)
                .readValue(json);
    }

    private void useJsonAlias() throws JsonProcessingException {
        System.out.print("------------------------------");
        System.out.println("\n@JsonAlias 注解使用");
        System.out.println("\n@JsonAlias 用于在反序列化期间为属性指定一个或多个别名");
        String json = "{\"f_name\": \"Lewis\", \"lastName\": \"Liu\"}";
        AliasBean bean = objectMapper.readValue(json, AliasBean.class);
    }

    private void useJsonIgnoreProperties() {
        System.out.print("------------------------------");
        System.out.println("\n@JsonIgnoreProperties 注解使用");
        System.out.println("\n@JsonIgnoreProperties ，作用在类上，用于指定在序列化/反序列化时需要忽略的属性");
    }

    private void processList() throws JsonProcessingException {
        String json = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"sellerName\": \"lewis\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"sellerName\": \"talia\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"sellerName\": \"test\"\n" +
                "    }\n" +
                "]";
        CollectionType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, MyBean.class);
        List<MyBean> myList = objectMapper.readValue(json, new TypeReference<List<MyBean>>() {
        });
        List<MyBean> myList2 = objectMapper.readValue(json, javaType);
    }

    private void processMap() throws JsonProcessingException {
        String json = "{\n" +
                "    \"1\": {\n" +
                "        \"id\": 1,\n" +
                "        \"sellerName\": \"lewis\"\n" +
                "    },\n" +
                "    \"2\": {\n" +
                "        \"id\": 2,\n" +
                "        \"sellerName\": \"talia\"\n" +
                "    },\n" +
                "    \"3\": {\n" +
                "        \"id\": 3,\n" +
                "        \"sellerName\": \"test\"\n" +
                "    }\n" +
                "}";
        MapType javaType = objectMapper
                .getTypeFactory()
                .constructMapType(HashMap.class, String.class, MyBean.class);
        HashMap<String, MyBean> beanMap = objectMapper.readValue(json, javaType);
        HashMap<String, MyBean> beanMap2 = objectMapper.readValue(json, new TypeReference<HashMap<String, MyBean>>() {
        });
//        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }


}
