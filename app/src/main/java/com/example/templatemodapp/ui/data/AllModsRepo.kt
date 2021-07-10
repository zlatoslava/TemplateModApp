package com.example.templatemodapp.ui.data

import com.example.templatemodapp.ui.data.models.Mod

object AllModsRepo {

    fun getAllModsList() = listOf(
        Mod(
            name = "name",
            description = "description",
            link = "link",
            icon = "https://www.mcicon.com/wp-content/uploads/2021/03/Cat-03.jpg"
        ),
        Mod(
            name = "name",
            description = "description",
            link = "link",
            icon = "https://www.mcicon.com/wp-content/uploads/2021/03/Cat-18.jpg"
        ),
        Mod(
            name = "name",
            description = "description",
            link = "link",
            icon = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAe1BMVEX///8AAACDg4Pl5eX19fXy8vJVVVX8/PxNTU34+PjMzMx2dnbT09Ph4eFcXFympqaTk5O5ubk1NTUNDQ2Kiora2tqxsbFra2vFxcUuLi4XFxdhYWHp6ekhISGcnJxHR0c/Pz9xcXG/v79+fn47OzuhoaEgICAoKCgTExOAAY1qAAAJO0lEQVR4nO2d63biOgxGSYFSKPdLKIVSoD3Tvv8THgJNm4tkS7KSOGt5/5uZhcZfEtuSLNudTiAQCAQCgUAgEAgEAoFAINAKFs/b+bgi2+P5/nlRkW1yG1ZRwr5Xge3e9GZ7VdXzIzGKfjj11W33T6nxkbptMuPol/eBsu3B6c94Y28xIzCKnpSNn7LGN8rGiUyiHFNN24PHvPGJpnEq/VW+EdFZ0fi2YHul38+tDHdRkbWa8Y+S7Z12P7cyeC81IopmSsaPgO2nuiUWP6M7Lyq2F6BtzU5AYA42QmfQGyO25wq2ycBP+co/d+emNIL9UqMDt8HacJ35nY1/4sZrmxZ7X3gjogdH488G27sq3F+IR0MjXL+l2Ghb1avAwUaZFBf/w/D93ziqqTAwsjQiWsptD0zf/40a4oz+P1sjog+x8bPV9lv17tve2gh5VzR3wjtbVTUAM0Ijouggst0l2Y6VFYkaIRzzzGO04+Oj8kRrhMgH/49oWzvWFjVC8qCJn8eV/ypQ9sPE/r/LH/TJbjSlW4G2O9RvNIH7ndKGsDuPlajr0AbzX5h5hwPHdlVRRp/VCObERZlmM1Tjgpu8fgiOg/XCtP1chUAs9EZ5Yxi3u4IFqkgSM8a6H+ijOpR6MuMeaZdgDTM/UAcb3jBzR915GwgaQQ4yuD38hrbCtaQRxMSKLeyFUU69Sb6jiOqBEz3uIrqRYjnNToMy5LEH6R9cc145GA5pHop7Cq0PkNB0T0VDwY102u9NxqPLIuUyGk9St4Q72f+hOO3TA5sS7y+z+b68THVnt5/PXgwZYBt6LxFehmketcUah1dYMVoJDXkvrBp53jKHcC6sBZ2XKHNn6kHFsemh63ke8D1UUMhJoNSPRukAOzitlS93gXKXox7cF6OEjn9tOC+a+jvbp7i6brYF3+ZxnDAGmNPsD0u3Yinfx5kEt7HG16gii9OqMDOR3xAuKX5JkrR+XFKn/Dx3Ezjkv32Om7LI84p+O91/yN1vcZ6vZsS1C/57bClSz60dI2mCdDRlrjw3yF4msB3T/Q3hdow2+KQpsk0CD003m4FsHeqt6WYz2EkEtmeuSJCkhtvi0NyRzBftmSsSJEFi021mwhcoK5BoDv5+mva4bHf4HbENGZos/PXgZdNNZvLJFdiu2TCBG0FZ9/54Bzdt6n82vwg3u9+2gYY95wN70X2HuX7Rouj3F14ULK0XbBJe6Td9+48/8LKmbYrvU3iHVlD3/7wfp5k/zXRG4HM2NJ0eqXlp3l4hksmneJh/29cfjh/cCoxWH+P8f399M8MFrVyCI5BQmb96uLtJBYXX38byFatTPCg+4HuOqUt5cJzpwh4crtOxuaTwykI2my5/N2xl/jLNoh3s5XWcEPFisfX45+ZCCiWbYHJ77QGF1/doGxwuDIWWLFQ22oQVdg7cdav3bGwAKrRG5Zzpwrj5YJnL3CEKuUWb+aEeUdjpGqNWTlrYNHZt8x0aVYgf8QJQ2DKJNntgygByCsAMj6o4r+IKGa5f0eFCFRp9Ec5xFa+olVIUZlDY2dDmxlVpEDQoNHz9/+gC8cii7BmZFBJTkuVR3qTQIJEeXaCbgIBdKkaFpGQIkH4wKuycMUv0VA3WgaCKALNCQtoVSnSaFaJeMz1+Qp78N1ReZVFojVLAId7y71hxPT0Zhaz+ggZsCk0nW105gb+xPQHkFdBXguFPC46/rArNmVe469gUIqMNPbMPepVIpseq0OijIuc+WRUOwBmbfooU+ISQj9yu0OA/YHO0VSHckehRPuSWYiUrBIV4UQfWcewKwQVc+kavM/BrbKGcoLAzBewloI4kQSFUN0lffwLSLeiOVIpCbH5F5y+CQmjPID3tDXwBaPkfRSEWZaCHsFAUAtM+vfgL+qqw2ZSgEB74IkMwQFAITYn08AkKD7GaHIJCPL2MnQ1CUAilguj5RDAARnIEdoWmNRAkGrArBJ+ao0JkNLUrNIXlSM+xKoQr0F0Vwr+3KjTn7eD8mFUhp4X038NOkU2hrd4f/DJsChFHkK4Qm6Gh+cum0JbkBKchi0JsfqWPpVjPeQUeuEWhfS8/5EuYFR6wNBJ9PkSXkJblrdNmhZSCB6DEwKgQX4Gn+zR4XH7iKaRVcJbnIZPC7LUQBegpYcMKcOnwd5NCaolqSaKh1QNDx6YfLmYa4Iu3kRgU0mtyih8qrrBnWrqjL80Yc4Cv+fQmrvBMFliKe1CFm2+TFXquzVLUlkuHYAq7vMWn3NITqtCSm2QUe+NZ/RvbTFoRUcivEs92Rlhh31Im8EoXaN9Z+fcaQYUTya6397+jzkGF1uQyZ6elfe1vl/ZqQGFXemTPOf1UM3+XKnyxF7xyavdsq9wJn3EfVDhyKTk5j0CF/ZhyXhZnlZtW1rbaXoa5153cI+Za8rdL7jjL/Hnd6S22tFU6VmGbZajJNCj7cLVOCcna+SQ/MsbyYcfvk5MweFVfbdqZl8Irg+413VwBzKMVzk23lw13w0X7PlPuNtJhm/ZXJryxzzVrWw0tf5+s+FDWhhAcOuD7IV95JJcJtGusEW1Xb8fhNHdOEoGteonCawnbcniL/JSh9rxE8c2S2PqFb8jPTmzLRlKHs3alh83Xi8vx8/a77DxAdOrHL23YDux4Rqu/Z3mnuJ7pPfA9ivpyvgnZ9xhD4U5yv8+pUbko2+euqHTFhb9BhtatT/g90g0Dbh4Q4etoozDKpPg58aveDUxZbqsbzmJaKyUqC+Ttl6yDCq6x9Ostqr/BBJ9OA6nigscrE1/mxW/FaSLPwQ/v5rPKe6t9OFyp4tvVmz8hS/lmxzIjcplGJbyqOjIwfc7d1do86l5cidFcTFzhrep5Js28xqfKJgmAJl6jSsKCzqHuQ3inVU6CMIRySD12NQyhALO6Jo7vmj/QP3r1zP9ztXSMgGH1GtdN6kvoH6vM+7/N65nizQzjqsacz1jjikoVnGq7MfbNjJ8YvaPuma7Low+fZ4HNWkvk7qGiLIUzw/HcvUt+rcfe9D6Qycyl5O9ppnklfHWMjo/8Eoe3x/nIeT23Roab+GNKnSlfpw/xpumJXcTw8DKb700XCr/t57OXQyvF5emOLnF8XD+ft/v9fnt+Xh/j+DJqR5cLBAKBQCAQCAQCgUAgEAgEaPwPTAGVzjghGCIAAAAASUVORK5CYII="
        ),
        Mod(
            name = "name",
            description = "description",
            link = "link",
            icon = "https://www.clipartkey.com/mpngs/m/128-1288930_cute-cat-emote-png-clipart-png-download-cute.png"
        )
    )
}