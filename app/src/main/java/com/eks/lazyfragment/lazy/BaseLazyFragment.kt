package com.eks.lazyfragment.lazy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by Riggs on 2020/2/27
 */
abstract class BaseLazyFragment : Fragment() {
    private var inflatedView: View? = null//fragment页面试图
    private var currentVisibleStatus = false//当前的可视状态

    //ps:生命周期的执行顺序,是会比setUserVisibleHint要慢.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (inflatedView == null) {
            inflatedView = inflater.inflate(getInflatLayout(), container, false)
        }
        if (userVisibleHint) dispatchEvent(true)//当fragment布局被填充后,如果fragment当前是处于可视状态,那就手动执行一下事件分发为true
        inflatedView?.let { initCompleted(it) }
        return inflatedView
    }

    override fun onResume() {
        super.onResume()
        //resume的时候,必须要满足"当前状态为不可视 而且当前fragment可视"的条件,才分发加载事件
        //因为fragment的生命周期是不会改变userVisibleHint的值
        if (!currentVisibleStatus && userVisibleHint) dispatchEvent(true)
    }

    override fun onPause() {
        super.onPause()
        //pause的时候,必须要满足"当前状态不可视 而且当fragment可视"的条件,才分发停止事件
        //因为fragment的生命周期是不会改变userVisibleHint的值
        if (currentVisibleStatus && userVisibleHint) dispatchEvent(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        currentVisibleStatus = false
    }

    /**
     * 页面初始化完毕,子类继续后续逻辑(但如果需要懒加载,则请求业务逻辑不能在这方法的具体实现中进行)
     */
    abstract fun initCompleted(inflatedView: View)
    /**
     * 传入布局资源,子类重写
     */
    abstract fun getInflatLayout(): Int
    /**
     * 目前fragment处于可视状态,可由子类重写
     * 结合viewPager使用时,该函数可代替onResume使用.
     */
    protected open fun onVisible() {}

    /**
     * 目前fragment处于不可视状态,可由子类重写,主要用于
     * 结合viewPager使用时,该函数可代替onPause使用.
     */
    protected open fun onInvisible() {}


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (inflatedView == null) return//如果fragment试图都没创建,那就别往后面执行了,往后分发出去就只会导致空指针.
        dispatchEvent(isVisibleToUser)
    }

    private fun dispatchEvent(isVisibleToUser: Boolean) {
        if (isVisibleToUser) {//现在可视
            if (!currentVisibleStatus) onVisible()//原本不可视,触发load
        } else {//现在不可视
            if (currentVisibleStatus) onInvisible()//原先可视,触发stopLoad
        }
        currentVisibleStatus = isVisibleToUser
    }


}