public interface Hotel {
    public Menus getMenus();
}

public class NonVegRestaurant implements Hotel {

    public Menus getMenus()
    {
        NonVegMenu nv = new NonVegMenu();
        return nv;
    }
}

public class VegRestaurant implements Hotel {

    public Menus getMenus()
    {
        VegMenu v = new VegMenu();
        return v;
    }
}

public class VegNonBothRestaurant implements Hotel {

    public Menus getMenus()
    {
        Both b = new Both();
        return b;
    }
}

public interface HotelKeeper {


    public VegMenu getVegMenu();
    public NonVegMenu getNonVegMenu();
    public Both getVegNonMenu();

}


public class HotelKeeperImplementation implements HotelKeeper {

    public VegMenu getVegMenu()
    {
        VegRestaurant v = new VegRestaurant();
        VegMenu vegMenu = (VegMenu)v.getMenus();
        return vegMenu;
    }

    public NonVegMenu getNonVegMenu()
    {
        NonVegRestaurant v = new NonVegRestaurant();
        NonVegMenu NonvegMenu = (NonVegMenu)v.getMenus();
        return NonvegMenu;
    }

    public Both getVegNonMenu()
    {
        VegNonBothRestaurant v = new VegNonBothRestaurant();
        Both bothMenu = (Both)v.getMenus();
        return bothMenu;
    }
}


public class Client
{
    public static void main (String[] args)
    {
        HotelKeeper keeper = new HotelKeeperImplementation();

        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        Both = keeper.getVegNonMenu();

    }
}