package JavaBasic;


import org.apache.commons.lang3.StringUtils;
import pojo.Address;
import pojo.Seller;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author ll0a
 */
public class JavaOptional {
    public void  process() {
        System.out.print("------------------------------");
        System.out.println("\nJava 使用 Optional 避免 NPE\n");

        initOptional();
        wrongWayToUseOptional();
        orElseMethod();
        orElseGetMethod();
        orElseThrowMethod();
        ifPresentMethod();
        mapMethod();
        flatMapMethod();
        filterMethod();
    }

    private void initOptional() {
        Optional<String> emptyOpt = Optional.empty();
        Optional<String> notnullOpt = Optional.of("String");
        Optional<String> nullableOpt = Optional.ofNullable("String");
    }

    private void wrongWayToUseOptional() {
        System.out.print("------------------------------");
        System.out.println("\nOptional 的错误使用方式\n");
        Optional<String> emptyOpt = Optional.empty();
        Optional<String> notnullOpt = Optional.of("String");
        emptyOpt.isPresent();
        System.out.println("isPresent -> " + emptyOpt.isPresent());
        System.out.println("get(),有值 -> " + notnullOpt.get());
        try {
            emptyOpt.get();
        } catch (NoSuchElementException exception) {
            System.out.println("get(),无值 -> " + exception.getMessage());
        }
    }

    private void orElseMethod() {
        System.out.print("------------------------------");
        System.out.println("\nOptional orElse() 方法");
        System.out.println("存在值则返回，无则返回默认值\n");
        Seller seller = new Seller("A001", "Lewis");
        Optional<Seller> sellerNotNullOpt = Optional.of(seller);
        Optional<Seller> sellerNullOpt = Optional.empty();
        Seller notNullSeller = sellerNotNullOpt.orElse(new Seller("A002", "LewisDefault"));
        Seller nullSeller = sellerNullOpt.orElse(new Seller("A002", "LewisDefault"));
        System.out.println("orElse() 有值 -> " + notNullSeller.getSellerId());
        System.out.println("orElse() 无值 -> " + nullSeller.getSellerId());
    }
    private void orElseGetMethod() {
        System.out.print("------------------------------");
        System.out.println("\nOptional elseGet() 方法");
        System.out.println("存在值则返回，无则调用函数产生默认值\n");
        Seller seller = new Seller("A001", "Lewis");
        Optional<Seller> sellerNotNullOpt = Optional.of(seller);
        Optional<Seller> sellerNullOpt = Optional.empty();
        Seller notNullSeller = sellerNotNullOpt.orElseGet(() -> new Seller("A002", "LewisDefault"));
        Seller nullSeller = sellerNullOpt.orElseGet(() -> new Seller("A002", "LewisDefault"));
        System.out.println("orElseGet() 有值 -> " + notNullSeller.getSellerId());
        System.out.println("orElseGet() 无值 -> " + nullSeller.getSellerId());
    }

    private void orElseThrowMethod() {
        System.out.print("------------------------------");
        System.out.println("\nOptional orElseThrow() 方法");
        System.out.println("存在值则返回，无值抛出指定的异常。\n");
        Seller seller = new Seller("A001", "Lewis");
        Optional<Seller> sellerNotNullOpt = Optional.of(seller);
        Optional<Seller> sellerNullOpt = Optional.empty();
        Seller notNullSeller = sellerNotNullOpt.orElseThrow(() -> new NoSuchElementException("No value present."));
        System.out.println("orElseThrow() 有值 -> " + notNullSeller.getSellerId());
        try {
            Seller nullSeller = sellerNullOpt.orElseThrow(() -> new NoSuchElementException("No value present."));
        } catch (NoSuchElementException exception) {
            System.out.println("orElseThrow() 无值 -> " + exception.getMessage());
        }
    }

    private void ifPresentMethod() {
        System.out.print("------------------------------");
        System.out.println("\nOptional ifPresent() 方法");
        System.out.println("存在值则调用指定的方法。\n");
        Seller seller = new Seller("A001", "Lewis");
        Optional<Seller> sellerNotNullOpt = Optional.of(seller);
        Optional<Seller> sellerNullOpt = Optional.empty();
        sellerNotNullOpt.ifPresent(s -> System.out.println("存在值，进行方法调用 ->" + seller.getSellerId()));
        sellerNullOpt.ifPresent(s -> System.out.println("不存在值，不进行方法调用"));
    }

    private void mapMethod() {
        System.out.print("------------------------------");
        System.out.println("\nOptional map() 方法\n");
        System.out.println("判断值是否存在，存在则用传入的 mapper 的返回值包装一个新的 Optional 返回，值不存在则返回一个空 Optional。\n");
        Seller seller = new Seller("A001", "Lewis", "address1");
        Optional<Seller> sellerNotNullOpt = Optional.of(seller);
        Optional<Seller> sellerNullOpt = Optional.empty();
        String notNullAddress = sellerNotNullOpt
                .map(Seller::getSellerAddress)
                .map(Address::getAddress1)
                .orElse("No address1.");
        String nullAddress = sellerNullOpt
                .map(Seller::getSellerAddress)
                .map(Address::getAddress1)
                .orElse("No address1.");

//        if (seller != null) {
//            Address address = seller.getSellerAddress();
//            if (address != null) {
//                String address1 = address.getAddress1();
//            } else {
//                return "No address1.";
//            }
//        } else {
//            return "No address1.";
//        }

        System.out.println("notNullAddress -> " + notNullAddress);
        System.out.println("nullAddress -> " + nullAddress);
    }

    private void flatMapMethod() {
        System.out.print("------------------------------");
        System.out.println("\nOptional flatMap() 方法\n");
        System.out.println("判断值是否存在，存在则 mapper 函数返回一个新的 Optional，值不存在则返回一个空 Optional。\n");
        Seller seller = new Seller("A001", "Lewis", "address1");
        Optional<Seller> sellerNotNullOpt = Optional.of(seller);
        String address1 = sellerNotNullOpt
                .flatMap(s -> Optional.ofNullable(s.getSellerAddress()))
                .flatMap(a -> Optional.ofNullable(a.getAddress1()))
                .orElse("No address1.");
        System.out.println("flatMap address1 -> " + address1);
    }

    private void filterMethod() {
        System.out.print("------------------------------");
        System.out.println("\nOptional filter() 方法\n");
        System.out.println("根据 Predicate 的计算结果，如果包含的值满足条件，那么还是返回这个 Optional；否则返回 Optional.empty。\n");
        Seller seller = new Seller("A001", "Lewis", "address1");
        Optional<Seller> sellerOpt = Optional.of(seller);
        Optional<Seller> sellerFilterOpt = sellerOpt.filter(c -> StringUtils.equalsIgnoreCase("A001", c.getSellerId()));
        System.out.println("filter result -> " + sellerFilterOpt.map(Seller::getSellerId).orElse("No this seller."));
    }

}
